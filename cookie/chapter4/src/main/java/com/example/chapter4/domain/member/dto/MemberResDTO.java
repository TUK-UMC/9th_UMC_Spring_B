package com.example.chapter4.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResDTO {
    @Builder
    public static class JoinDTO {
        private final Long memberId;
        private final String createAt; // 생성일시(원하는 타입대로 변경)

        public Long getMemberId() { return memberId; }
        public String getCreateAt() { return createAt; }
    }
    @Builder
    public record LoginDTO(
            Long memberId,
            String accessToken
    ){}
}
