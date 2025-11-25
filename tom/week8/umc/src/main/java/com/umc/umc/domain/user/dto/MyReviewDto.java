package com.umc.umc.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MyReviewDto {

    private Long reviewId;
    private String storeName;
    private String title;
    private String content;
    private Double rate;
    private LocalDateTime createTime;

}
