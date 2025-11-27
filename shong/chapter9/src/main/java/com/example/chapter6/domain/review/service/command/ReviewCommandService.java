package com.example.chapter6.domain.review.service.command;

import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.CreateReviewDTO createReview(Long memberId, ReviewReqDTO.CreateReviewDTO dto);
}
