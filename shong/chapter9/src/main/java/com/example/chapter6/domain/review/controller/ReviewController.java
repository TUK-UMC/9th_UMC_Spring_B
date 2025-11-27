package com.example.chapter6.domain.review.controller;

import com.example.chapter6.domain.review.converter.ReviewConverter;
import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;
import com.example.chapter6.domain.review.entity.Review;
import com.example.chapter6.domain.review.service.command.ReviewCommandService;
import com.example.chapter6.domain.review.service.query.ReviewQueryService;
import com.example.chapter6.global.annotation.CheckPage;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
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

    // --- [내 리뷰 목록 조회 API] ---
    @GetMapping("/me")
    @Operation(summary = "내가 쓴 리뷰 목록 조회 API", description = "마이페이지에서 내가 작성한 리뷰 목록을 조회합니다. 페이징(10개 단위)을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "page 번호가 1보다 작습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작), 1 미만 입력 시 에러 발생")
    })
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviewList(
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        Long memberId = 1L;
        Page<Review> reviewPage = reviewQueryService.getMyReviewList(memberId, page);
        ReviewResDTO.ReviewPreViewListDTO resultDTO = ReviewConverter.toReviewPreViewListDTO(reviewPage);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDTO);
    }

}