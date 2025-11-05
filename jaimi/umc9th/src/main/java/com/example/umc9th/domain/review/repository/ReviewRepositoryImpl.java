package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.user.entity.Quser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// QueryDSL을 이용한 동적 쿼리 구현체
// 조건(가게명, 별점대)에 따라 리뷰 필터링
@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    // 하나의 API에서 가게명 & 별점대 필터링을 모두 처리
    public List<ReviewResponseDto> findMyReviews(Long userId, String storeName, Integer starRange) {
        QReview review = QReview.review;
        Quser user = Quser.user;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();

        // 🔹 기본 조건: 로그인한 유저의 리뷰만
        builder.and(review.user.id.eq(userId));

        // 🔹 가게명 필터
        if (storeName != null && !storeName.isBlank()) {
            builder.and(store.name.contains(storeName));
        }

        // 🔹 별점대 필터 (예: 5 -> 5점대, 4 -> 4점대)
        if (starRange != null) {
            // 예를 들어 starRange == 4면 4.0 이상 5.0 미만
            builder.and(review.star.goe(starRange).and(review.star.lt(starRange + 1)));
        }

        // 🔹 QueryDSL 쿼리 실행
        return queryFactory
                .select(
                        // new 연산자로 DTO 직접 매핑
                        new com.example.umc9th.domain.review.dto.QReviewResponseDto(
                                user.name,
                                store.name,
                                review.star,
                                review.content,
                                review.reply,
                                review.createdDate.stringValue()
                        )
                )
                .from(review)
                .join(review.user, user)
                .join(review.store, store)
                .where(builder)
                .orderBy(review.createdDate.desc()) // 최신순 정렬
                .fetch();
    }
}
