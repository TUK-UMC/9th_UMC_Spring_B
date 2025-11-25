package com.umc.umc.domain.review.converter;

import com.umc.umc.domain.review.dto.req.ReviewCreateRequest;
import com.umc.umc.domain.review.dto.res.ReviewCreateResponse;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewConverter {

    public Review toEntity (ReviewCreateRequest request, User user, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .rate(request.getRate())
                .user(user)
                .store(store)
                .build();
    }

    public ReviewCreateResponse toReviewCreateResponse(Review review) {
        return new ReviewCreateResponse(
                review.getId(),
                review.getUser().getId(),
                review.getStore().getId(),
                review.getTitle(),
                review.getContent(),
                review.getRate(),
                review.getCreateTime()
        );
    }
}
