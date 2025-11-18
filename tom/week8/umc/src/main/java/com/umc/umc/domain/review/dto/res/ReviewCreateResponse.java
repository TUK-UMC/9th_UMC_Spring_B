package com.umc.umc.domain.review.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewCreateResponse {
    private Long reviewId;
    private Long userId;
    private Long storeId;
    private String title;
    private String content;
    private Double rate;
    private LocalDateTime createTime;
}
