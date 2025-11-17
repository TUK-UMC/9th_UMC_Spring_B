package com.umc.umc.domain.review.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.umc.umc.domain.review.entity.QReview.*;
import static com.umc.umc.domain.store.entity.QStore.*;
import static com.umc.umc.domain.user.entity.QUser.*;

@RequiredArgsConstructor
public class ReviewRepositoryQueryDslImpl implements ReviewRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MyReviewDto> findMyReviews(Long userId, MyReviewSearchCond cond, Pageable pageable) {

        List<MyReviewDto> content = queryFactory
                .select(Projections.constructor(MyReviewDto.class,
                        review.id,
                        store.name,
                        review.title,
                        review.content,
                        review.rate,
                        review.createTime))
                .from(review)
                .join(review.store, store)
                .where(
                        user.id.eq(userId), // 내가 쓴 리뷰
                        storeNameEq(cond.getStoreName()), // 가게 이름(값이 있는 경우에만)
                        ratingRange(cond.getRating()) // 별점 (값이 있는 경우에만)
                )
                .orderBy(review.createTime.desc()) // 리뷰 최신순 정리
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); // 결과가 여러개이므로 fetch

       Long total = queryFactory
               .select(review.count())
               .from(review)
               .join(review.store, store)
               .join(review.user, user)
               .where(
                       user.id.eq(userId),
                       storeNameEq(cond.getStoreName()),
                       ratingRange(cond.getRating())
               )
               .fetchOne(); // 결과가 하나이므로 fetchOne

        return new PageImpl<>(content, pageable, (total != null) ? total : 0L); // total은 값이 존재하면 total 값을 반환하고 없다면 0을 반환한다.
    }

    private BooleanExpression storeNameEq(String storeName) { // 가게 이름 필터
        return StringUtils.hasText(storeName) ? store.name.eq(storeName) : null;
    }

    private BooleanExpression ratingRange(Double rating) { // 별점 필터
        if (rating == null) {
            return null;
        }
        if (rating == 5.0) {
            return review.rate.eq(5.0);
        } else if (rating == 4.0 || rating == 4.5) {
            return review.rate.eq(4.0);
        } else if (rating == 3.0 || rating == 3.5) {
            return review.rate.eq(3.0);
        }  else if (rating == 2.0 || rating == 2.5) {
            return review.rate.eq(2.0);
        } else if (rating == 1.0 || rating == 1.5) {
            return review.rate.eq(1.0);
        } else if (rating == 0.0 || rating == 0.5) {
            return review.rate.eq(0.0);
        }
        return null;
    }
}
