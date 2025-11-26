package com.example.chapter4.domain.review.exception;

import com.example.chapter4.global.apiPayload.code.BaseErrorCode;
import com.example.chapter4.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}