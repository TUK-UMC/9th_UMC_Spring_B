package com.example.chapter4.domain.mission.service.command;

import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;

public interface MissionCommandService {
    MissionChallengeResDTO challengeMission(MissionChallengeReqDTO dto);
}
