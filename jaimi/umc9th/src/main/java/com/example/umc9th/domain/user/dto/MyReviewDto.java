package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyReviewDto {
    private String storeName;
    private String content;
    private float rate;
    private String createdDate;
}
