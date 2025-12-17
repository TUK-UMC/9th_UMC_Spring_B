package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;


// 회원가입 관련 로직을 정의하는 인터페이스
public interface MemberCommandService {

    // 회원가입 메서드 정의
    MemberResDTO.JoinResultDTO joinMember(MemberReqDTO.JoinDTO request);
    MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO request);
}