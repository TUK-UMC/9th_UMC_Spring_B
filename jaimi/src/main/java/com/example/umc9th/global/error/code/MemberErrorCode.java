package com.example.umc9th.global.error.code;

import org.springframework.http.HttpStatus;

public enum MemberErrorCode {


    NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "해당 사용자를 찾을 수 없습니다."), // findByEmail 실패 시
    INVALID(HttpStatus.UNAUTHORIZED, "MEMBER401", "이메일 또는 비밀번호가 일치하지 않습니다."), // 비밀번호 검증 실패 시


    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    MemberErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }


    public HttpStatus getHttpStatus() { return httpStatus; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
}