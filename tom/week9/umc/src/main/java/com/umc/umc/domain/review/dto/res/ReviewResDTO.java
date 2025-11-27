package com.umc.umc.domain.review.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResDTO {

    @Getter
    @AllArgsConstructor
    public static class ReviewCreateResponse {
        private Long reviewId;
        private Long userId;
        private Long storeId;
        private String title;
        private String content;
        private Double rate;
        private LocalDateTime createTime;
    }

}
