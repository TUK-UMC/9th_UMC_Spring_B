package com.example.chapter6.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // JPQL의 'new' 키워드는 생성자를 호출합니다.
public class MyPageInfoDTO {

    private String name;        // m.name
    private String email;       // m.email
    private String isVerified;  // m.is_verified
    private Integer point;      // m.point
}