package com.umc.umc.domain.store.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class RegionException extends GeneralException {
    public RegionException(BaseErrorCode code) {
        super(code);
    }
}
