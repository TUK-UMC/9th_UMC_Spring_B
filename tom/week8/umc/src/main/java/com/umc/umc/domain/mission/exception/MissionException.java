package com.umc.umc.domain.mission.exception;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import com.umc.umc.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
