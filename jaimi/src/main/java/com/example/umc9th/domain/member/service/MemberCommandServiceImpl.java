package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.auth.JwtUtil;
import com.example.umc9th.global.auth.enums.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.apiPayload.handler.GeneralHandler;
import com.example.umc9th.global.auth.CustomUserDetails;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // 주입
    private final JwtUtil jwtUtil;

    @Override
    public MemberResDTO.JoinResultDTO joinMember(MemberReqDTO.JoinDTO request) {

        String encodedPassword = passwordEncoder.encode(request.password());

        Member newMember = MemberConverter.toMember(request, encodedPassword, Role.ROLE_USER);

        memberRepository.save(newMember);

        return MemberConverter.toJoinResultDTO(newMember);
    }

    @Override
    public MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO request) {
        // 이메일로 회원이 있는지 확인
        Member member = memberRepository.findByEmail(request.email())
                .orElseThrow(() -> new GeneralHandler(ErrorStatus.MEMBER_NOT_FOUND));

        // 비밀번호가 맞는지 확인
        if (!passwordEncoder.matches(request.password(), member.getPassword())) {
            throw new GeneralHandler(ErrorStatus.PASSWORD_NOT_MATCH);
        }

        // 토큰 발급
        CustomUserDetails userDetails = new CustomUserDetails(member);
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // 결과 반환
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}