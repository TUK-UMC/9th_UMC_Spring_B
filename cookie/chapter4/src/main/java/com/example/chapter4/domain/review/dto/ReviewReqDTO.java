package com.example.chapter4.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewReqDTO {
    private final Long menuId; // 리뷰 대상 메뉴 ID
    private final Float rating; // 별점
    private final String content; // 리뷰 내용

    @Builder
    public ReviewReqDTO(Long menuId, Float rating, String content) {
        this.menuId = menuId;
        this.rating = rating;
        this.content = content;
    }
}
