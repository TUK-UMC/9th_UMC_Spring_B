package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    // 공통 성공 코드
    SUCCESS(HttpStatus.OK, "200", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "201", "리소스가 성공적으로 생성되었습니다."),
    ACCEPTED(HttpStatus.ACCEPTED, "202", "요청이 접수되었습니다."),

    // user
    USER_REGISTERED(HttpStatus.CREATED, "S001", "회원가입이 완료되었습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "S002", "로그인이 성공적으로 완료되었습니다."),

    // mission
    MISSION_LIST_SUCCESS(HttpStatus.OK, "S101", "미션 목록 조회에 성공했습니다."),
    MISSION_REGION_LIST_SUCCESS(HttpStatus.OK, "S102", "지역별 미션 목록 조회에 성공했습니다."),

    // 리뷰
    REVIEW_LIST_SUCCESS(HttpStatus.OK, "S301", "리뷰 목록 조회에 성공했습니다."),

    // 가게
    STORE_LIST_SUCCESS(HttpStatus.OK, "S401", "가게 목록 조회에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
