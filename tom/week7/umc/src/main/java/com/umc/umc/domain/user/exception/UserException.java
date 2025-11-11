package com.umc.umc.domain.user.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode code) {
        super(code);
    }
}
