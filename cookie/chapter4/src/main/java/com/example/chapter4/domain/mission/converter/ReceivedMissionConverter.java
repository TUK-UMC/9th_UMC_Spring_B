package com.example.chapter4.domain.mission.converter;

import com.example.chapter4.domain.mission.dto.MissionProgressDto;
import com.example.chapter4.domain.mission.entity.ReceivedMission;

public class ReceivedMissionConverter {
    public static MissionProgressDto toDto(ReceivedMission rm) {
        return MissionProgressDto.builder()
                .receivedMissionId(rm.getId())
                .missionId(rm.getMission().getId())
                .title(rm.getMission().getTitle())
                .description(rm.getMission().getDescription())
                .status(rm.getStatus())
                .deadline(rm.getDeadline())
                .build();
    }
}
