package com.umc.umc.domain.review.service;

import com.umc.umc.domain.review.dto.req.ReviewCreateRequest;
import com.umc.umc.domain.review.dto.res.ReviewCreateResponse;

public interface ReviewService {
    public ReviewCreateResponse createReview(ReviewCreateRequest request, Long UserId, Long storeId);
}
