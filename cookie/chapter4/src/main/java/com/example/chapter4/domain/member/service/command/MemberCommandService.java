package com.example.chapter4.domain.member.service.command;

import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;

public interface MemberCommandService {
    //회원가입
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );

    // 회원가입

}
