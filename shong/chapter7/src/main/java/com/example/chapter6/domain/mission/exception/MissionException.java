package com.example.chapter6.domain.mission.exception;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}