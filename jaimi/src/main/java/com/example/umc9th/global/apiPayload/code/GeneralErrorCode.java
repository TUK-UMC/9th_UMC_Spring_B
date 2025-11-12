package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralErrorCode implements BaseErrorCode{

    // 상태 코드 400 bad Resquest
    // 상세 코드 COMMON400_1 -> 에러 구분용 내부 코드
    // 메시지
    BAD_REQUEST(HttpStatus.BAD_REQUEST,
            "COMMON400_1",
            "잘못된 요청입니다."),

    // 401 Unauthorized
    // AUTH401_1 -> 인증 실패 관련 세부 식별 코드
    // 메시지
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED,
            "AUTH401_1",
            "인증이 필요합니다."),

    // 403 Forbidden
    // AUTH403_1 -> 권한 거부 관련 세부 코드
    // 메시지
    FORBIDDEN(HttpStatus.FORBIDDEN,
            "AUTH403_1",
            "요청이 거부되었습니다."),

    // 404 Not Found
    // COMMON404_1 -> 존재하지 않는 리소스 세부 코드
    // 메시지
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "COMMON404_1",
            "요청한 리소스를 찾을 수 없습니다."),
    ;

    // 필드 설명
    // stauts : HTTP 응답 코드
    // code : 내부적으로 세부 구분을 위한 에러 식별 코드
    // message : 클라인언트(사용자)에게 전달할 에러 설명 문구
    private final HttpStatus status;
    private final String code;
    private final String message;
}
