package com.example.umc9th.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReviewCreateRequest {
        private Long storeId;
        private int rating;
        private String content;
}


