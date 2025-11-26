package com.example.chapter4.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionResDto {
    private final Long id;
    private final String title;
    private final String description;
}
