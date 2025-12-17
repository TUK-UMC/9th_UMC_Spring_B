package com.example.umc9th.global.apiPayload.code.status;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 공통 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의하세요."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4001", "사용자를 찾을 수 없습니다."),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "MEMBER4002", "비밀번호가 일치하지 않습니다."),

    TOKEN_NO_AUTH(HttpStatus.FORBIDDEN, "AUTH4001", "권한이 없습니다."),
    TOKEN_INVALID(HttpStatus.BAD_REQUEST, "AUTH4002", "유효하지 않은 토큰입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public com.example.umc9th.global.apiPayload.code.ReasonDTO getReason() {
        return com.example.umc9th.global.apiPayload.code.ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public com.example.umc9th.global.apiPayload.code.ReasonDTO getReasonHttpStatus() {
        return com.example.umc9th.global.apiPayload.code.ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
    public HttpStatus getStatus() {
        return httpStatus;
    }
}