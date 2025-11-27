package com.example.chapter6.domain.member.service.query;

import com.example.chapter6.domain.member.dto.MyPageInfoDTO;


// Member 조회 관련 서비스 인터페이스

public interface MemberQueryService {

    /**
     * 마이페이지 정보 조회
     * 리턴값 MyPageInfoDTO
     */
    MyPageInfoDTO getMyPageInfo(Long memberId);
}