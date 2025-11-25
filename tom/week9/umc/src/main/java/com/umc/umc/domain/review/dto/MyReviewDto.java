package com.umc.umc.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class MyReviewDto {

    private Long reviewId;
    private String storeName;
    private String title;
    private String content;
    private Double rate;
    private LocalDateTime createTime;

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDto {
        private String storeName;
        private String title;
        private Double rate;
        private String content;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewListDto {
        private List<ReviewDto> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
