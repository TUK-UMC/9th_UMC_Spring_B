package com.example.chapter4.domain.review.service;

import com.example.chapter4.domain.review.dto.ReviewResDTO;
import com.example.chapter4.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryService {
    ReviewResDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    );

    // 검색 API
    List<Review> searchReview(
            String filter,
            String type
    )throws Exception;

    ReviewResDTO.ReviewPreViewListDTO findReview();

}
