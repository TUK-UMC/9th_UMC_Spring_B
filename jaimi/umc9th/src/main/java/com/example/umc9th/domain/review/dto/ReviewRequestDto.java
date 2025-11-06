package com.example.umc9th.domain.review.dto;

import lombok.Getter;

@Getter
public class ReviewRequestDto {
    private Long userId;
    private Long storeId;
    private float reviewRate;
    private String reviewContent;
}
