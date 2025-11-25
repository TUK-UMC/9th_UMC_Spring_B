package com.umc.umc.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MissionChallengeRes {
    private final Long missionStatusId;
    private String status;
    private LocalDateTime createTime;
}
