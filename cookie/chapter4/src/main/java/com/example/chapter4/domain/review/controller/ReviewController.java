package com.example.chapter4.domain.review.controller;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import com.example.chapter4.domain.review.service.ReviewService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import com.example.chapter4.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // 내가 작성한 리뷰 전체 조회 API (응답 통일 + 페이징)
    @GetMapping("/my")
    public ApiResponse<Page<MyReviewDto>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starFloor,
            Pageable pageable
    ) {
        Page<MyReviewDto> reviews = reviewService.getMyReviews(memberId, storeName, starFloor, pageable);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}
