package com.example.chapter6.domain.mission.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {
    // 미션 관련 예외가 필요할 경우 여기에 정의.
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1", "미션을 찾을 수 없습니다."),

    MISSION_ALREADY_ACCEPTED(HttpStatus.CONFLICT, "MISSION409_1", "이미 수락한 미션입니다. 중복 도전할 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}