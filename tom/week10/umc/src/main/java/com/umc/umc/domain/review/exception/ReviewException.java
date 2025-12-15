package com.umc.umc.domain.review.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
