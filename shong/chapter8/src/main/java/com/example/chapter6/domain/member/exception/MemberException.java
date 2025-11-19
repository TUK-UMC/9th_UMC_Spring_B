package com.example.chapter6.domain.member.exception;

import com.example.chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;


// Member 도메인 관련 예외
public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}