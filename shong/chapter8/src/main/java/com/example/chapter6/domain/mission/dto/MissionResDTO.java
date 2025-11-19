package com.example.chapter6.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDateTime;

public class MissionResDTO {

    // 미션 수락 응답 DTO
    @Builder
    public record AcceptMissionDTO(
            Long receivedMissionId,
            LocalDateTime acceptedAt
    ) {}
}
