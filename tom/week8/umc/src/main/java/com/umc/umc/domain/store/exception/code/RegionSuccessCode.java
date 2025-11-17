package com.umc.umc.domain.store.exception.code;

import com.umc.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RegionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "REGION200_1",
            "지역을 성공적으로 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "REGION201_1",
            "지역이 성공적으로 생성되었습니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
