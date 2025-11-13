package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class MyPageResponseDto {
    private String nickname;
    private String email;
    private int point;
    private List<MyReviewDto> reviews;
}
