package com.umc.umc.domain.review.dto.req;

import lombok.Getter;

@Getter
public class ReviewCreateRequest {
    private String title;
    private String content;
    private Double rate;
}
