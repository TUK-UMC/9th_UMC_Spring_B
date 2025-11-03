// review/dto/MemberReviewDTO.java
package com.example.chapter4.domain.review.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class MemberReviewDTO {
    private String storeName;
    private String menuName;
    private Float rating;
    private String content;
    private LocalDateTime createdAt;

    // [리팩토링] Repository의 @Query에서 DTO로 바로 받기 위한 생성자
    public MemberReviewDTO(String storeName, String menuName, Float rating, String content, LocalDateTime createdAt) {
        this.storeName = storeName;
        this.menuName = menuName;
        this.rating = rating;
        this.content = content;
        this.createdAt = createdAt;
    }
}