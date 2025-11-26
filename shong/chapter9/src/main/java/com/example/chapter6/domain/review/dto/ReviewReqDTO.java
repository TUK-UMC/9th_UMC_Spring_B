package com.example.chapter6.domain.review.dto;

public class ReviewReqDTO {
    public record CreateReviewDTO(
            Long menuId,          // 리뷰 대상 메뉴 ID (필수)
            Float rating,         // 평점 (필수)
            String content,       // 리뷰 내용
            String photo          // 사진 URL
    ) {}
}
