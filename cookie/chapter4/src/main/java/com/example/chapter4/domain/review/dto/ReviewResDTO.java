package com.example.chapter4.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ReviewResDTO {
    private final Long reviewId;
    private final Long memberId;
    private final Long menuId;
    private final Float rating;
    private final String content;

    @Builder
    public ReviewResDTO(Long reviewId, Long memberId, Long menuId, Float rating, String content) {
        this.reviewId = reviewId;
        this.memberId = memberId;
        this.menuId = menuId;
        this.rating = rating;
        this.content = content;


    }
    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ){}
}
