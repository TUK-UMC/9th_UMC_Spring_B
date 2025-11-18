package com.umc.umc.domain.review.controller;

import com.umc.umc.domain.review.dto.req.ReviewCreateRequest;
import com.umc.umc.domain.review.dto.res.ReviewCreateResponse;
import com.umc.umc.domain.review.exception.code.ReviewSuccessCode;
import com.umc.umc.domain.review.service.ReviewService;
import com.umc.umc.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewCreateResponse> createReview(
            @RequestBody @Valid ReviewCreateRequest request,
            @RequestHeader Long userId,
            @PathVariable Long storeId) {

        ReviewCreateResponse reviewCreateResponse = reviewService.createReview(request, userId, storeId);
        return ApiResponse.success(ReviewSuccessCode.CREATED, reviewCreateResponse );
    }
}
