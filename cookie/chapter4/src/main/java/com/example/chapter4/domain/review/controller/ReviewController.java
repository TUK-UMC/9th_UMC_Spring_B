package com.example.chapter4.domain.review.controller;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import com.example.chapter4.domain.review.dto.ReviewReqDTO;
import com.example.chapter4.domain.review.dto.ReviewResDTO;
import com.example.chapter4.domain.review.service.ReviewService;
import com.example.chapter4.domain.review.service.ReviewCommandService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import com.example.chapter4.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

// 리뷰 관련 API를 담당하는 컨트롤러
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewCommandService reviewCommandService;

    // 내가 작성한 리뷰 전체 조회 API (페이징 및 조건)
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

    // 가게에 리뷰 추가하기 API
    @PostMapping
    public ApiResponse<ReviewResDTO> addReview(@RequestBody ReviewReqDTO dto) {
        ReviewResDTO resDTO = reviewCommandService.addReview(dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resDTO);
    }
}
