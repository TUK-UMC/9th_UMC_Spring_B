package com.umc.umc.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode{

    OK(HttpStatus.OK,
            "COMMON200_1",
            "요청 성공"),
    CREATED(HttpStatus.CREATED,
            "COMMON201_1",
            "새로운 리소스가 생성"),
    ACCEPTED(HttpStatus.ACCEPTED,
            "COMMON202_1",
            "요청을 수신하였지만 그에 응하여 행동할 수 없습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON204_1",
            "요청 성공, 반환할 내용 없음"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
