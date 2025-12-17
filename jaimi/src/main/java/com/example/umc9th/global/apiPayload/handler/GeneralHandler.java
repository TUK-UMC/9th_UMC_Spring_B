package com.example.umc9th.global.apiPayload.handler;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.exception.GeneralException;

public class GeneralHandler extends GeneralException {

    public GeneralHandler(BaseErrorCode code) {
        super(code);
    }
}