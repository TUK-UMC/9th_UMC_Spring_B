package com.example.chapter6.domain.review.exception.code;

import com.example.chapter6.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    REVIEW_SUCCESS_CODE(HttpStatus.OK,
            "REVIEW200_1",
            "성공적으로 리뷰를 조회했습니다."),

    REVIEW_CREATED(HttpStatus.CREATED,
            "REVIEW201_1",
                    "리뷰 작성에 성공했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
