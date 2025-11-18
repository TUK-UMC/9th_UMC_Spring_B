package com.umc.umc.domain.mission.converter;

import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.entity.MissionStatus;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public Mission toMission(MissionCreateReq request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .store(store)
                .build();
    }

    public MissionCreateRes toMissionCreateRes(Mission mission) {
        return new MissionCreateRes(
                mission.getId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getCreateTime()
        );
    }

    public MissionStatus toMissionStatus(User user, Mission mission) {
        return MissionStatus.builder()
                .user(user)
                .mission(mission)
                .status("ONGOING")
                .build();
    }

    public MissionChallengeRes toMissionChallengeResponse(MissionStatus missionStatus) {
        return new MissionChallengeRes(
                missionStatus.getId(),
                missionStatus.getStatus(),
                missionStatus.getCreateTime()
        );
    }

}
