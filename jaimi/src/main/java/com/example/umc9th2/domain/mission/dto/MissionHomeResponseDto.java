package com.example.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionHomeResponseDto {
    private String storeName;
    private String address;
    private String missionExplain;
    private int missionAward;
}
