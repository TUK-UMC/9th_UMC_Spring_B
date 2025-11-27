package com.example.chapter6.domain.review.dto;

import lombok.Builder;
import java.time.LocalDateTime;

public class ReviewResDTO {
    @Builder
    public record CreateReviewDTO(
            Long reviewId,
            LocalDateTime createdAt
    ) {}
}