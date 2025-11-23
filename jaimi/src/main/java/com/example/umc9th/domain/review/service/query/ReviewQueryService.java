package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import java.util.List;


public interface ReviewQueryService {
    // 검색 API
    List<Review> searchReview(
        String filter,
        String type
    ) throws Exception;
    ReviewResponseDto.ReviewPreViewListDTO findReview(Long ReviewId);

    ReviewResponseDto.ReviewPreViewListDTO getMyReviews(Long userId, int page);
}
