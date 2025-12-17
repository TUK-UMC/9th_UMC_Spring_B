package com.example.chapter4.domain.member.converter;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;
import com.example.chapter4.global.auth.enums.Role;


public class MemberConverter {

    private static String password;
    private static Role role;

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
            MemberReqDTO.JoinDTO dto,
            String salt, Role roleUser){
        
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .birth(dto.birth())
                .address(dto.address())
                .address(dto.specAddress())
                .gender(dto.gender())
                .build();
    }
}