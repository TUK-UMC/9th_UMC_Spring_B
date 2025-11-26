package com.example.chapter6.domain.review.dto;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {
    @Builder
    public record CreateReviewDTO(
            Long reviewId,
            LocalDateTime createdAt
    ) {}
// --- 리뷰 목록 조회용 DTO ---
    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record ReviewPreViewDTO(
            String storeName,
            String menuName,
            Float rating,
            String content,
            LocalDateTime createdAt
    ) {}
}