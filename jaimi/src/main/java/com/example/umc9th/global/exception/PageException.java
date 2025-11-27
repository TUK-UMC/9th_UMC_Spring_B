package com.example.umc9th.global.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;

@Getter
public class PageException extends RuntimeException {

    private final BaseErrorCode code;

    public PageException(BaseErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }
}