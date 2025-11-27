package com.example.chapter4.domain.mission.service.command;

import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;
import com.example.chapter4.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionCommandService {
    MissionChallengeResDTO challengeMission(MissionChallengeReqDTO dto);

    Page<Mission> getMissionsByStore(Long storeId, Pageable pageable);
}
