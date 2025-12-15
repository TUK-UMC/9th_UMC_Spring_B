package com.umc.umc.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MypageDto {
    private String username;
    private String email;
    private String phoneNumber;
    private Integer points;
}


