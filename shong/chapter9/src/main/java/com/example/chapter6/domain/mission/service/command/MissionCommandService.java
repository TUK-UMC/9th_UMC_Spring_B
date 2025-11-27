package com.example.chapter6.domain.mission.service.command;

import com.example.chapter6.domain.mission.dto.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.AcceptMissionDTO acceptMission(Long memberId, Long missionId);

    // 미션 완료 처리
    MissionResDTO.MissionCompleteDTO completeMission(Long memberId, Long receivedMissionId);

}
