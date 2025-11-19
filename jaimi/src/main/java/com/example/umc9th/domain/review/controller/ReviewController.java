package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewRequestDto;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRequestDto reviewService;

    @PostMapping("/{storeId}/reviews")
    public String addReview(
            @PathVariable Long storeId,
            @RequestBody ReviewRequestDto reviewRequestDto
    ) {
        // userId는 로그인 구현 전이므로 하드코딩
        reviewService.addReview(storeId, 1L, reviewRequestDto);
        return "리뷰 등록 완료";
    }
}

