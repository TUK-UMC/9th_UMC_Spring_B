package com.umc.umc.domain.mission.service;

import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.dto.res.MissionResponseDto;
import com.umc.umc.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public interface MissionService {
    MissionCreateRes createMission(MissionCreateReq request, Long storeId);

    MissionChallengeRes challengeMission(Long userId, Long missionId);

    Page<Mission> getMissionList(Long storeId, Integer page);

    MissionResponseDto.OnGoingListDto getMyOngoingMission(Long userId, Integer page);
}
