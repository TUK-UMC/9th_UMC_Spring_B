package com.example.chapter6.domain.review.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    // 리뷰 관련 예외가 필요할 경우 여기에 정의합니다.
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "리뷰를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}