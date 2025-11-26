package com.example.chapter4.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionProgressDto {
    private final Long receivedMissionId;
    private final Long missionId;
    private final String title;
    private final String description;
    private final String status;
    private final LocalDateTime deadline;
}
