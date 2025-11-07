package com.example.chapter4.domain.review.repository;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewQueryDslRepository {
    Page<MyReviewDto> findMyReviews(Long memberId, String storeName, Integer starFloor, Pageable pageable);
}
