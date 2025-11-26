package com.example.chapter6.global.apiPayload.handler;

import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.chapter6.global.apiPayload.code.GeneralErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//이 어노테이션은 애플리케이션의 모든 @RestController에서 발생하는 예외를
//클래스(GeneralExceptionAdvice)가 전역적으로 가로채서 처리하도록 설정합니다.
//컨트롤러 단에서 발생하는 오류를 이 클래스가 모두 잡아냅니다.
@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 애플리케이션에서 발생하는 커스텀 예외를 처리
    // @RestControllerAdvice`가 예외를 가로챘을 때,
    // 만약 그 예외가 GeneralException 타입(또는 그 자식 타입)이라면
    // 이 메서드(handleException)가 실행되도록 지정합니다.
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            GeneralException ex) {

        return ResponseEntity.status(ex.getCode().getStatus())
                .body(ApiResponse.onFailure(
                        ex.getCode(),
                        null
                )
        );
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex
    ) {

        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(code, ex.getMessage()));
    }
}
