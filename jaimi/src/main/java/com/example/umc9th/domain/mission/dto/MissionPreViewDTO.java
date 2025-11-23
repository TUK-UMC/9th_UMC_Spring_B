package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
import com.example.umc9th.domain.mission.entity.MissionStatus;

@Builder
@Getter
public class MissionPreViewDTO {
    private Long missionId;
    private String missionExplain;
    private String missionAward;
    private String storeName;
    private String userName;
    private MissionStatus status;
}
