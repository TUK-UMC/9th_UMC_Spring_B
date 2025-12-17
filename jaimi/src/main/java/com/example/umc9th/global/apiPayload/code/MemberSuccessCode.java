package com.example.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public enum MemberSuccessCode implements BaseCode {

    // MemberController에서 사용된 성공 코드
    FOUND(HttpStatus.OK, "MEMBER2001", "요청하신 정보를 성공적으로 조회했습니다."),

    // 회원가입 성공 코드 추가
    MEMBER_JOIN(HttpStatus.CREATED, "MEMBER2000", "회원가입이 성공했습니다.")

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    MemberSuccessCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}