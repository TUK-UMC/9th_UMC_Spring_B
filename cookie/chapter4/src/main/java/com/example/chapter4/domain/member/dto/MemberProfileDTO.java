package com.example.chapter4.domain.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberProfileDTO {
    private String nickname;
    private String email;
    private String phoneStatus; // 인증 여부
    private Integer point;
    // ... 작성한 리뷰는 별도 목록 등으로 추가 가능
}
