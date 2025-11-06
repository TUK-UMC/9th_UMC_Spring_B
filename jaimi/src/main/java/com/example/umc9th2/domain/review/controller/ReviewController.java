package com.example.domain.review.controller;

import com.example.domain.review.dto.ReviewResponseDto;
import com.example.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 // ReviewController
 // HTTP 요청을 받아서 Service에 전달
 // JSON 형태로 응답 반환
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    // [내가 작성한 리뷰 보기 API]
    //필터링 조건: 가게명, 별점대
     // 예시: /api/reviews/my?userId=1&storeName=반이학생마라탕마라반&starRange=4

    @GetMapping("/my")
    public List<ReviewResponseDto> getMyReviews(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starRange
    ) {
        return reviewService.getMyReviews(userId, storeName, starRange);
    }
}
