package com.example.chapter6.domain.mission.service.command;

import com.example.chapter6.domain.mission.dto.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.AcceptMissionDTO acceptMission(Long memberId, Long missionId);
}
