package com.example.chapter6.domain.member.service.command;

import com.example.chapter6.domain.member.dto.MemberReqDTO;
import com.example.chapter6.domain.member.dto.MemberResDTO;

public interface MemberCommandService {
    // 회원가입
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}
