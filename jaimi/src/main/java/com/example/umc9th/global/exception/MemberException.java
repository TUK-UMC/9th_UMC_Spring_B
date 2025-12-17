package com.example.umc9th.global.exception;

import com.example.umc9th.global.error.code.MemberErrorCode;


public class MemberException extends RuntimeException {

    private final MemberErrorCode errorCode;

    public MemberException(MemberErrorCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public MemberErrorCode getErrorCode() {
        return errorCode;
    }
}