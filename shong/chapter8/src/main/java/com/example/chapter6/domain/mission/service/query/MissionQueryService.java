package com.example.chapter6.domain.mission.service.query;

import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


// Mission 조회(Query) 관련 서비스 인터페이스

public interface MissionQueryService {


    // 내가 진행중/완료한 미션 목록 조회
    Page<MyMissionDTO> getMyMissions(Long memberId, String status, Pageable pageable);

}