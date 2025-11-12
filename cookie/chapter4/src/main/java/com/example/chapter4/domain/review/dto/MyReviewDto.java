package com.example.chapter4.domain.review.dto;

import java.time.LocalDateTime;

public class MyReviewDto {
    private Long reviewId;
    private String storeName;
    private String menuName;
    private String content;
    private Float rating;
    private LocalDateTime createdAt;

    // 생성자, getter, setter 등 생략
}
