package com.example.chapter6.domain.member.service.query;

import com.example.chapter6.domain.member.dto.MyPageInfoDTO;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public MyPageInfoDTO getMyPageInfo(Long memberId) {

        // 1. Repository를 호출.
        return memberRepository.findMyPageInfo(memberId)

                // 2. [응답 통일 - 실패]
                //    데이터가 없으면 MemberException(MEMBER_NOT_FOUND)을 던집니다.
                //    이 예외는 GeneralExceptionAdvice가 가로채서 404 응답을 반환.
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
    }
}