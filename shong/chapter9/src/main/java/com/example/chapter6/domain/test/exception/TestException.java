package com.example.chapter6.domain.test.exception;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
