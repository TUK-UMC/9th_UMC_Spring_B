package com.example.chapter4.domain.review.controller;

import com.example.chapter4.domain.review.dto.MyReviewDto;
import com.example.chapter4.domain.review.dto.ReviewReqDTO;
import com.example.chapter4.domain.review.dto.ReviewResDTO;
import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter4.domain.review.exception.code.ReviewSuccessCode;
import com.example.chapter4.domain.review.service.ReviewQueryService;
import com.example.chapter4.domain.review.service.ReviewService;
import com.example.chapter4.domain.review.service.ReviewCommandService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import com.example.chapter4.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 리뷰 관련 API를 담당하는 컨트롤러
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController implements ReviewControllerDocs {

    private final ReviewService reviewService;
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    // 내가 작성한 리뷰 전체 조회 API (페이징 및 조건)
    @GetMapping("/my")
    @Operation(summary = "내가 작성한 리뷰 조회", description = "페이징(10개씩), page 쿼리스트링 검증 포함")
    public ApiResponse<Page<MyReviewDto>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starFloor,
            Integer page
    ) {
        {
            // 1 이상의 page만 허용
            if (page== null || page < 1) {
                throw new IllegalArgumentException("page는 1 이상이어야 합니다.");
            }
            Pageable pageable = PageRequest.of(page - 1, 10); // page는 1-base
            Page<MyReviewDto> reviews = reviewService.getMyReviews(memberId, pageable);
            return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
        }
    }

    // 가게에 리뷰 추가하기 API
    @PostMapping
    public ApiResponse<ReviewResDTO> addReview(@RequestBody ReviewReqDTO dto) {
        ReviewResDTO resDTO = reviewCommandService.addReview(dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resDTO);
    }



    @GetMapping("/reviews/search")
    public List<Review> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception {

        // 서비스에 요청
        List<Review> result = reviewQueryService.searchReview(filter, type);
        return result;
    }

    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews() {

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return null;
    }


}
