package com.example.chapter6.domain.review.exception;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}