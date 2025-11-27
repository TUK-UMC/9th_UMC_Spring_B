package com.umc.umc.domain.store.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode code) {
        super(code);
    }
}
