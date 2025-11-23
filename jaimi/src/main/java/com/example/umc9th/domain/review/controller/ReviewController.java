package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController implements ReviewControllerDocs{

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<Review> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception{

        // 서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(filter, type);
        return result;
    }

    // 가게의 리뷰 목록 조회
    @Override
    @GetMapping("/reviews")
    public ApiResponse<ReviewResponseDto.ReviewPreViewListDTO> getReviews(
        @RequestParam String storeName,
        @RequestParam(defaultValue = "1") Integer page
    ){
            ReviewSuccessCode code = ReviewSuccessCode.REVIEW_FOUND;

            ReviewResponseDto.ReviewPreViewListDTO result = null;

            return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }
}