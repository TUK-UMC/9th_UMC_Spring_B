package com.example.chapter6.domain.member.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Member 도메인 관련 Error Code
 *
 */
@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    // Member 관련
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404_1", "회원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}