package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.service.MemberCommandService;
import com.example.umc9th.domain.member.service.MemberQueryService;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.global.apiPayload.code.ApiResponse;
import com.example.umc9th.global.apiPayload.code.MemberSuccessCode;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinResultDTO> signUp(@RequestBody @Valid MemberReqDTO.JoinDTO request){
        MemberResDTO.JoinResultDTO result = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(result);
    }

    @PostMapping("/login")
    public ApiResponse<MemberResDTO.LoginDTO> login(@RequestBody @Valid MemberReqDTO.LoginDTO request){
        MemberResDTO.LoginDTO result = memberCommandService.login(request);
        return ApiResponse.onSuccess(result);
    }

    @PostMapping("/logout")
    public ApiResponse<String> logout() {
        return ApiResponse.onSuccess("로그아웃 성공!");
    }
}

