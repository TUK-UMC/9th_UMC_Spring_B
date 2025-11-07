package com.example.chapter4.domain.review.service;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import com.example.chapter4.domain.review.repository.ReviewQueryDslRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewQueryDslRepository reviewQueryDslRepository;

    public ReviewService(ReviewQueryDslRepository reviewQueryDslRepository) {
        this.reviewQueryDslRepository = reviewQueryDslRepository;
    }

    // 내가 작성한 리뷰 조회 (가게/별점 필터 및 페이징)
    public Page<MyReviewDto> getMyReviews(Long memberId, String storeName, Integer starFloor, Pageable pageable) {
        return reviewQueryDslRepository.findMyReviews(memberId, storeName, starFloor, pageable);
    }
}
