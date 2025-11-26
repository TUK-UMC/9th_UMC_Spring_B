package com.example.chapter6.domain.mission.service.query;

import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


// Mission 조회(Query) 관련 서비스 인터페이스

public interface MissionQueryService {


    // 내가 진행중/완료한 미션 목록 조회
    Page<ReceivedMission> getMyMissions(Long memberId, String status, Integer page);

    // 특정 가게의 미션 목록 조회
    Page<Mission> getMissionList(Long storeId, Integer page);


}