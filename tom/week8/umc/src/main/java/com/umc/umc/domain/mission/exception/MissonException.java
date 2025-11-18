package com.umc.umc.domain.mission.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class MissonException extends GeneralException {
    public MissonException(BaseErrorCode code) {
        super(code);
    }
}
