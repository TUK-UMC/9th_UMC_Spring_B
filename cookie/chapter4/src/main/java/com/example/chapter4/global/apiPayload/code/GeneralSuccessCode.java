package com.example.chapter4.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public enum GeneralSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "S200", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "S201", "리소스가 성공적으로 생성되었습니다."),
    ACCEPTED(HttpStatus.ACCEPTED, "S202", "요청이 성공적으로 접수되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    GeneralSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
