package com.example.chapter4.domain.review.repository;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.chapter4.domain.review.entity.QReview.review;
import static com.example.chapter4.domain.member.entity.QMember.member;
import static com.example.chapter4.domain.store.entity.QMenu.menu;
import static com.example.chapter4.domain.store.entity.QStore.store;

@Repository
public class ReviewQueryDslRepositoryImpl implements ReviewQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public ReviewQueryDslRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<MyReviewDto> findMyReviews(Long memberId, String storeName, Integer starFloor, Pageable pageable) {
        List<MyReviewDto> content = queryFactory
                .select(Projections.constructor(MyReviewDto.class,
                        review.id,
                        store.name,
                        menu.name,
                        review.content,
                        review.rating,
                        review.createdAt
                ))
                .from(review)
                .join(review.menu, menu)
                .join(menu.store, store)
                .where(
                        review.member.id.eq(memberId),
                        review.status.eq("ACTIVE"),
                        storeNameEq(storeName),
                        ratingFloorBetween(starFloor)
                )
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(review.count())
                .from(review)
                .join(review.menu, menu)
                .join(menu.store, store)
                .where(
                        review.member.id.eq(memberId),
                        review.status.eq("ACTIVE"),
                        storeNameEq(storeName),
                        ratingFloorBetween(starFloor)
                )
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0L);
    }

    private BooleanExpression storeNameEq(String storeName) {
        return StringUtils.hasText(storeName) ? store.name.eq(storeName) : null;
    }

    // 별점층: 5, 4~5, 3~4점대 등
    private BooleanExpression ratingFloorBetween(Integer starFloor) {
        if (starFloor == null) return null;
        if (starFloor == 5) return review.rating.eq(5.0f);
        return review.rating.goe(starFloor.floatValue()).and(review.rating.lt(starFloor.floatValue() + 1));
    }
}
