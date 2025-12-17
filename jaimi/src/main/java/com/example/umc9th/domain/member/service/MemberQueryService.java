package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;

public interface MemberQueryService {

    // 로그인 메서드 정의
    MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto);
}