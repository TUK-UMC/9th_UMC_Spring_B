package com.umc.umc.domain.review.dto.req;

import lombok.Getter;

public class ReviewReqDTO {

    @Getter
    public static class ReviewCreateRequest {
        private String title;
        private String content;
        private Double rate;
    }

    @Getter
    public static class Review {
    }

}
