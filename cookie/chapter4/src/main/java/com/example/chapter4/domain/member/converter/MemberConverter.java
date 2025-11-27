package com.example.chapter4.domain.member.converter;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;


public class MemberConverter {

    // Entity -> DTO
    public static MemberResDTO.JoinDTO toJoinDTO(
            Member member
    ){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(String.valueOf(member.getCreatedAt()))
                .build();
    }

    // DTO -> Entity
    public static Member toMember(
            MemberReqDTO.JoinDTO dto
    ){
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .address(dto.address())
                .address(dto.specAddress())
                .gender(dto.gender())
                .build();
    }
}