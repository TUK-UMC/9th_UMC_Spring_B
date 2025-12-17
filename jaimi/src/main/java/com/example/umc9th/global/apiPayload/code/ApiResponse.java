package com.example.umc9th.global.apiPayload.code;

import com.example.umc9th.global.apiPayload.code.BaseCode;
import com.example.umc9th.global.apiPayload.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private Boolean isSuccess;
    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    // 성공 시: 데이터 포함
    public static <T> ApiResponse<T> onSuccess(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), result);
    }

    // 성공 시: 데이터 없음
    public static ApiResponse<Void> onSuccess(BaseCode code) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), null);
    }

    // 실패 시
    public static <T> ApiResponse<T> onFailure(BaseCode code, T result) {
        return new ApiResponse<>(false, code.getCode(), code.getMessage(), result);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(false, code, message, data);
    }

    // BaseErrorCode를 받는 버전
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, T data) {
        return new ApiResponse<>(false, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), data);
    }
}