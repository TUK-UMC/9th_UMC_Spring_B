package com.example.chapter4.domain.member.service.query;

import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;
import jakarta.validation.Valid;

public class MemberQueryService {

    public MemberResDTO.LoginDTO login(MemberReqDTO.@Valid LoginDTO dto) {
        return null;
    }
}
