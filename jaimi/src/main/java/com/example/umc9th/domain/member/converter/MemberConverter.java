package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.auth.enums.Role;


public class MemberConverter {

    public static Member toMember(MemberReqDTO.JoinDTO request, String encodedPassword, Role role) {
        return Member.builder()
                .name(request.name())
                .email(request.email())
                .password(encodedPassword) // 암호화된 비밀번호
                .role(role)
                .gender(request.gender())
                .birth(request.birth())
                .address(request.address())
                .detailAddress(request.specAddress())
                .build();
    }

    // 회원가입 응답용
    public static MemberResDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedDate())
                .build();
    }
}