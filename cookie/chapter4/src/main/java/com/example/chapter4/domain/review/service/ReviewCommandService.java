package com.example.chapter4.domain.review.service;

import com.example.chapter4.domain.review.dto.ReviewReqDTO;
import com.example.chapter4.domain.review.dto.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO addReview(ReviewReqDTO dto);
}
