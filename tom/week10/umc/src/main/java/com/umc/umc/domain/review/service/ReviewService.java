package com.umc.umc.domain.review.service;

import com.umc.umc.domain.review.dto.req.ReviewReqDTO;
import com.umc.umc.domain.review.dto.res.ReviewResDTO;

public interface ReviewService {
    public ReviewResDTO.ReviewCreateResponse createReview(ReviewReqDTO.ReviewCreateRequest request, Long UserId, Long storeId);
}
