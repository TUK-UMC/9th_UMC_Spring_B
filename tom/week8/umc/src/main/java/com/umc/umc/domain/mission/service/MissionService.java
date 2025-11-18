package com.umc.umc.domain.mission.service;

import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;

public interface MissionService {
    MissionCreateRes createMission(MissionCreateReq request, Long storeId);
}
