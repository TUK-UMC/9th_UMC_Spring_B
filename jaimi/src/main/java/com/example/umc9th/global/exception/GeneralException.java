package com.example.umc9th.global.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;

// 사용자 정의 예외 클래스 ErrorCode를 포함하여 구체적인 에러 정보를 전달
@Getter
public class GeneralException extends RuntimeException {

    // 에러 코드 정보
    private final BaseErrorCode code;

    // 생성자
    //code 에러 코드 Enum
    public GeneralException(BaseErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

     // 생성자 (커스텀 메시지 포함)
     // code 에러 코드 Enum
     // message 커스텀 메시지
    public GeneralException(BaseErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}