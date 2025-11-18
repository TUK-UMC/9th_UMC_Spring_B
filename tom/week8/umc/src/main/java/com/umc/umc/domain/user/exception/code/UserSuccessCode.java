package com.umc.umc.domain.user.exception.code;

import com.umc.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "USER200_1",
            "사용자를 성공적으로 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "USER201_1",
            "사용자가 성공적으로 생성되었습니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
