package com.example.chapter4.domain.review.repository;

import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter4.domain.review.entity.QReview;
import com.example.chapter4.domain.store.entity.QStore;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public ReviewQueryDslRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    // 가게별, 별점별 동적 필터
    public List<Review> findMyReviews(Long memberId, String storeName, Integer starFloor) {
        QReview review = QReview.review;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(
                        review.member.id.eq(memberId),
                        storeNameEq(storeName),
                        starFloorBetween(starFloor)
                )
                .orderBy(review.createdAt.desc())
                .fetch();
    }

    // 가게 이름 필터 (없으면 무시)
    private BooleanExpression storeNameEq(String storeName) {
        return (storeName == null || storeName.trim().isEmpty()) ? null
                : QStore.store.name.eq(storeName.trim());
    }

    // 별점 층별 필터. 5점, 4점대(4~5), 3점대(3~4)
    private BooleanExpression starFloorBetween(Integer starFloor) {
        if (starFloor == null) return null;
        if (starFloor == 5) return QReview.review.star.eq(5.0);
        return QReview.review.star.goe(starFloor)
                .and(QReview.review.star.lt(starFloor + 1));
    }
}
