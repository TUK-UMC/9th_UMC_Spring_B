package com.example.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonalMissionResponseDto {
    private String storeName;       // 가게 이름
    private String missionExplain;  // 미션 설명
    private int missionAward;       // 포인트
    private String progress;        // 진행 상태 (진행중 / 완료)
}
