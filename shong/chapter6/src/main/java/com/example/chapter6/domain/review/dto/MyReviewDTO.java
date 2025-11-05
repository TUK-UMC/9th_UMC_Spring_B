package com.example.chapter6.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor // JPQL의 'new' 키워드는 생성자를 호출합니다.
public class MyReviewDTO {

    private String storeName;     // s.name
    private String menuName;      // m.name
    private Float rating;         // r.rating
    private String content;       // r.content
    private LocalDateTime createdAt; // r.created_at
}