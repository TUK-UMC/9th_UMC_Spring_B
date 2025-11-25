package com.umc.umc.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class OngoingMissionDto {
    private String storeName;
    private String title;
    private String description;
    private String status;
    private LocalDateTime completionTime;
}

