package com.umc.umc.domain.mission.exception.code;

import com.umc.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "MISSION200_1",
            "미션을 성공적으로 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "MISSION201_1",
            "미션이 성공적으로 생성되었습니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
