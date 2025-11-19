package com.example.chapter6.domain.member.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Member 도메인 관련 Success Code
 *
 */
@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    // Member 관련
    MEMBER_FOUND(HttpStatus.OK,
            "MEMBER200_1",
            "성공적으로 사용자를 조회했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
