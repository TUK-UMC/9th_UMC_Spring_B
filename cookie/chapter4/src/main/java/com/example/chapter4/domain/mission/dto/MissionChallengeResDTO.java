package com.example.chapter4.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MissionChallengeResDTO {
    private final Long receivedMissionId;
    private final Long missionId;
    private final Long storeId;
    private final Long memberId;
    private final String status; // 예: "IN_PROGRESS", "COMPLETED"

    @Builder
    public MissionChallengeResDTO(Long receivedMissionId, Long missionId, Long storeId, Long memberId, String status) {
        this.receivedMissionId = receivedMissionId;
        this.missionId = missionId;
        this.storeId = storeId;
        this.memberId = memberId;
        this.status = status;
    }
}
