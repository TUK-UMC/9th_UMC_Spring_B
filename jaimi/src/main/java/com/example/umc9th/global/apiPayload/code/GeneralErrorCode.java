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

    // 공통 에러 코드
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST,
            "COMMON400_2",
            "잘못된 입력값입니다."),

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

    // 405 Method Not Allowed
    // 허용되지 않은 HTTP 메서드 (공통 코드)
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED,
            "COMMON405_1",
            "허용되지 않은 HTTP 메서드입니다."),

    // 500 Internal Server Error
    // 서버 내부 오류 (예상치 못한 에러) 공통 코드 -> GeneralExceptionAdvice에서 사용
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "COMMON500_1",
            "서버 내부 오류가 발생했습니다."),

    // === 도메인별 에러 코드 (필요시 추가) === //

    // Mission 관련
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,
            "MISSION404_1",
            "미션을 찾을 수 없습니다."),

    // Review 관련
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "리뷰를 찾을 수 없습니다."),

    // User 관련
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,
            "USER404_1",
            "사용자를 찾을 수 없습니다."),
    ;

    // 필드 설명
    // stauts : HTTP 응답 코드
    // code : 내부적으로 세부 구분을 위한 에러 식별 코드
    // message : 클라인언트(사용자)에게 전달할 에러 설명 문구
    private final HttpStatus status;
    private final String code;
    private final String message;
}
