package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.auth.enums.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.umc9th.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // 주입

    @Override
    public MemberResDTO.JoinResultDTO joinMember(MemberReqDTO.JoinDTO request) {


        String encodedPassword = passwordEncoder.encode(request.password());


        Member newMember = MemberConverter.toMember(request, encodedPassword, Role.ROLE_USER);


        memberRepository.save(newMember);

        return MemberConverter.toJoinResultDTO(newMember);
    }
}