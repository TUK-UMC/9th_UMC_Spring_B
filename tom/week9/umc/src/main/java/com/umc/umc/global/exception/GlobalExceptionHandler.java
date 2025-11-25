package com.umc.umc.global.exception;

import com.umc.umc.global.apiPayload.ApiResponse;
import com.umc.umc.global.apiPayload.code.GeneralErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ApiResponse<Object> validation(jakarta.validation.ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(violation -> violation.getMessage())
                .findFirst()
                .orElse("유효하지 않은 페이지 번호입니다.");

        return ApiResponse.onFailure(GeneralErrorCode.PAGE_NOT_VALID, errorMessage);
    }
}
