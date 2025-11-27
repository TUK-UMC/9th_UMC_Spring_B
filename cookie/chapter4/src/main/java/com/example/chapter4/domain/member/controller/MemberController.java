package com.example.chapter4.domain.member.controller;

import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;
import com.example.chapter4.domain.member.exception.code.MemberSuccessCode;
import com.example.chapter4.domain.member.service.command.MemberCommandService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody MemberReqDTO.JoinDTO dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signup(dto));
    }
}