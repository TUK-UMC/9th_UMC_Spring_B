package com.example.chapter6.domain.member.converter;

import com.example.chapter6.domain.member.dto.MemberReqDTO;
import com.example.chapter6.domain.member.dto.MemberResDTO;
import com.example.chapter6.domain.member.entity.Member;

public class MemberConverter {

    // Entity -> DTO
    public static MemberResDTO.JoinDTO toJoinDTO(
            Member member
    ){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
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
                .specAddress(dto.specAddress())
                .gender(dto.gender())
                .build();

    }
}
