package com.example.umc9th.domain.store.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum StoreSuccessCode implements BaseErrorCode {
    STORE_FOUND(HttpStatus.OK, "STORE200_1", "가게 조회에 성공했습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;

    StoreSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {return status;}
    @Override
    public String getCode() {return code;}
    @Override
    public String getMessage() {return message;}

}
