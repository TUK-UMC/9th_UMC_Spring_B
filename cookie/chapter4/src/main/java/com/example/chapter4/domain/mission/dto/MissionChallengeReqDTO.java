package com.example.chapter4.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MissionChallengeReqDTO {
    private final Long missionId;
    private final Long storeId;

    @Builder
    public MissionChallengeReqDTO(Long missionId, Long storeId) {
        this.missionId = missionId;
        this.storeId = storeId;
    }
}
