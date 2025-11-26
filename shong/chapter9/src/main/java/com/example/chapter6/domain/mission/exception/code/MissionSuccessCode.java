// File: com/example/chapter6/domain/mission/exception/code/MissionSuccessCode.java

package com.example.chapter6.domain.mission.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    MISSION_ACCEPT_SUCCESS(HttpStatus.CREATED, // HTTP 201 (생성됨)
            "MISSION201_1",
            "성공적으로 미션을 수락했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}