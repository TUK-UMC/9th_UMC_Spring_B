package com.example.chapter4.domain.review.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewCreateDTO {

    private Long memberId;

    private Long menuId;

    private Float rating;

    private String content;

    private String photo;
}
