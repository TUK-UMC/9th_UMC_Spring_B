package com.example.chapter4.domain.store.exception.code;

import com.example.chapter4.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreSuccessCode implements BaseErrorCode {

    FOUND(HttpStatus.FOUND,
            "REVIEW404_1",
            "해당 리뷰를 찾았습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}