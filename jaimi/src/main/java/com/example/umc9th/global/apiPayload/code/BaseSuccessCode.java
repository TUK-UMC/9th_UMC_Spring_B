package com.example.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {

    // HTTP 상태 코드 (200, 201 등)
    HttpStatus getStatus();

    // 성공 코드 (문자열 형태의 고유 코드값)
    String getCode();

    // 성공 메시지
    String getMessage();
}
