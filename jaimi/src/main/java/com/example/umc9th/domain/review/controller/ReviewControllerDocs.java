package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReviewControllerDocs {
    @Operation(
            summary = "가게의 리뷰 목록 조희 API(개발 중)",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이징 형태로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "성공"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode ="400",
                    description = "실패"
            )
    })
    ApiResponse<ReviewResponseDto.ReviewPreViewListDTO> getReviews();
}
