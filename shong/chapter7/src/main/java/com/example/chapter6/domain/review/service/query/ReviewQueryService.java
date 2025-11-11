package com.example.chapter6.domain.review.service.query;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import java.util.List;

/**
 * Review 조회(Query) 관련 서비스 인터페이스
 */
public interface ReviewQueryService {

    /**
     * 내가 작성한 리뷰 목록 동적 조회
     */
    List<MyReviewDTO> getMyReviews(Long memberId, String storeName, Integer ratingFilter);
}