package com.example.chapter6.domain.review.repository;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.querydsl.core.types.Projections; // DTO로 바로 조회 결과를 받기 위해 사용
import com.querydsl.core.types.dsl.BooleanExpression; // 동적 쿼리(WHERE 절)를 만들기 위해 사용
import com.querydsl.jpa.impl.JPAQueryFactory; // QueryDSL의 핵심 클래스
import lombok.RequiredArgsConstructor; // final 필드에 대한 생성자 자동 주입
import org.springframework.util.StringUtils; // storeName이 null이거나 비어있는지 확인

import java.util.List;

import static com.example.chapter6.domain.review.entity.QReview.review;
import static com.example.chapter6.domain.store.entity.QMenu.menu;
import static com.example.chapter6.domain.store.entity.QStore.store;


/**
 * ReviewRepositoryCustom 인터페이스를 실제로 구현하는 클래스입니다.
 * Spring Data JPA가 인식할 수 있도록 클래스 이름은 반드시
 * (기존 리포지토리 이름 + Impl) 이어야 합. (e.g., ReviewRepository + Impl)
 */
@RequiredArgsConstructor // final로 선언된 JPAQueryFactory를 생성자를 통해 주입받습니다.
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    // QueryDSL 쿼리를 생성하고 실행하기 위한 핵심 객체입니다.
    // QueryDslConfig에서 @Bean으로 등록한 것을 주입받습니다.
    private final JPAQueryFactory queryFactory;

    /**
     * 마이 페이지 - 내가 작성한 리뷰 목록 동적 조회 (QueryDSL 구현체)
     *
     * @param memberId     필수: 현재 로그인한 회원 ID
     * @param storeName    선택: 필터링할 가게 이름 (null이면 전체)
     * @param ratingFilter 선택: 필터링할 별점 (null이면 전체)
     */
    @Override
    public List<MyReviewDTO> findMyReviewsDynamic(Long memberId, String storeName, Integer ratingFilter) {

        // queryFactory를 사용하여 쿼리 빌드를 시작합니다.
        return queryFactory
                // [SELECT 절]
                // 쿼리 결과를 MyReviewDTO 객체로 바로 생성해서 받습니다.
                .select(Projections.constructor(MyReviewDTO.class,
                        store.name,       // MyReviewDTO 생성자의 첫 번째 파라미터 (storeName)
                        menu.name,        // MyReviewDTO 생성자의 두 번째 파라미터 (menuName)
                        review.rating,    // MyReviewDTO 생성자의 세 번째 파라미터 (rating)
                        review.content,   // MyReviewDTO 생성자의 네 번째 파라미터 (content)
                        review.createdAt  // MyReviewDTO 생성자의 다섯 번째 파라미터 (createdAt)
                ))

                // [FROM 절]
                // 리뷰(review) 테이블을 기준으로 조회를 시작합니다.
                .from(review)

                // [JOIN 절]
                // Review -> Menu -> Store 순서로 조인하여 가게 이름(store.name)을 가져옵니다.
                // (SQL: ... FROM review r JOIN menu m ON r.menu_id = m.id ...)
                .join(review.menu, menu)
                // (SQL: ... JOIN store s ON m.store_id = s.id)
                .join(menu.store, store)

                // [WHERE 절]
                // 모든 조건을 여기에 넣습니다.
                .where(
                        // 1. 기본 조건 (필수): 내가 쓴 리뷰여야 함
                        review.member.id.eq(memberId),
                        // 1. 기본 조건 (필수): 활성화된(삭제되지 않은) 리뷰
                        review.status.eq("ACTIVE"),

                        // 2. 동적 조건 (가게별 필터링): storeNameEq() 메서드 호출
                        //    - storeName이 null이면 -> null을 반환 -> WHERE 절에서 무시됨
                        //    - storeName이 "..."이면 -> store.name.eq("...") 조건을 반환 -> WHERE 절에 추가됨
                        storeNameEq(storeName),

                        // 3. 동적 조건 (별점별 필터링): ratingFilterEq() 메서드 호출
                        //    - ratingFilter가 null이면 -> null을 반환 -> WHERE 절에서 무시됨
                        //    - ratingFilter가 4이면 -> (rating >= 4.0 AND rating < 5.0) 조건을 반환 -> WHERE 절에 추가됨
                        ratingFilterEq(ratingFilter)
                )

                // [ORDER BY 절]
                // 최신순으로 정렬합니다. (SQL: ORDER BY r.created_at DESC)
                .orderBy(review.createdAt.desc())

                // [쿼리 실행]
                // 지금까지 조립된 쿼리를 데이터베이스로 실행하고,
                // 결과를 List<MyReviewDTO> 형태로 반환받습니다.
                .fetch();
    }

    /**
     * 가게 이름 필터링 조건을 생성하는 헬퍼 메서드
     *
     * storeName 컨트롤러에서 받은 가게 이름 파라미터
     * return BooleanExpression (QueryDSL의 WHERE 절 조건) 또는 null
     */
    private BooleanExpression storeNameEq(String storeName) {
        // StringUtils.hasText(): storeName이 null이 아니고, ""(빈 문자열)도 아니어야 true
        return StringUtils.hasText(storeName)
                ? store.name.eq(storeName) // (조건 있음) SQL: store.name = ?
                : null;                    // (조건 없음) null을 반환하여 이 조건을 무시하도록 함
    }

    /**
     * 별점 필터링 조건을 생성하는 메서드
     *
     * rating 컨트롤러에서 받은 별점 파라미터 (e.g., 5, 4, 3)
     * BooleanExpression (QueryDSL의 WHERE 절 조건) 또는 null
     */
    private BooleanExpression ratingFilterEq(Integer rating) {
        // (조건 없음) null이면 null 반환
        if (rating == null) {
            return null;
        }

        // (5점 조회) rating이 5이면, 5.0과 정확히 일치하는 리뷰
        if (rating == 5) {
            // SQL: review.rating = 5.0
            return review.rating.eq(5.0f);
        }
        // (1~4점대 조회) rating이 1, 2, 3, 4 중 하나이면 (e.g., 4점대)
        else if (rating >= 1 && rating <= 4) {
            // float로 변환 (e.g., 4 -> 4.0f)
            float floatRating = rating.floatValue();

            // SQL: review.rating >= 4.0 AND review.rating < 5.0
            return review.rating.goe(floatRating) // goe (>= Greater Or Equal)
                    .and(review.rating.lt(floatRating + 1.0f)); // lt ( < Less Than)
        }
        // 그 외의 값 (e.g., 0이나 6 이상)은 유효하지 않으므로 무시
        else {
            return null;
        }
    }
}