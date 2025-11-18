package com.umc.umc.domain.mission.exception.code;

import com.umc.umc.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "MISSION404_1",
            "해당 미션을 찾지 못했습니다."),

    MISSION_ALREADY_CHALLENGED(HttpStatus.INTERNAL_SERVER_ERROR,
            "MISSION500_1",
            "이미 완료된 미션입니다.")
    ;



    private final HttpStatus status;
    private final String code;
    private final String message;
}
