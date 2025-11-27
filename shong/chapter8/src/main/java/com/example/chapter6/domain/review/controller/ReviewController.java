package com.example.chapter6.domain.review.controller;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;
import com.example.chapter6.domain.review.service.command.ReviewCommandService;
import com.example.chapter6.domain.review.service.query.ReviewQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    // QueryService 주입
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    // 리뷰 작성 API
    @PostMapping("/")
    public ApiResponse<ReviewResDTO.CreateReviewDTO> createReview(
            @RequestBody @Valid ReviewReqDTO.CreateReviewDTO dto
    ) {
        Long memberId = 1L; // (임시 ID - 실제로는 Spring Security Context에서 가져와야 함)

        ReviewResDTO.CreateReviewDTO resultDto = reviewCommandService.createReview(memberId, dto);

        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resultDto);
    }

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