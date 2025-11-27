package com.example.chapter4.domain.store.exception;

import com.example.chapter4.domain.store.entity.Store;
import com.example.chapter4.global.apiPayload.code.BaseErrorCode;
import com.example.chapter4.global.apiPayload.exception.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode code) {
        super(code);
    }
}