package com.example.chapter6.domain.review.controller;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.service.query.ReviewQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    // QueryService 주입
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/me")
    public ApiResponse<List<MyReviewDTO>> getMyReviews(
            @RequestParam(name = "storeName", required = false) String storeName,
            @RequestParam(name = "rating", required = false) Integer rating
    ) {

        Long memberId = 1L; // (임시 ID)

        // 1. Service 호출
        List<MyReviewDTO> resultDtoList = reviewQueryService.getMyReviews(memberId, storeName, rating);

        // 2. [응답 통일 - 성공]
        //    (결과가 0건이어도 빈 리스트 '[]'를 성공으로 반환)
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDtoList);
    }
}