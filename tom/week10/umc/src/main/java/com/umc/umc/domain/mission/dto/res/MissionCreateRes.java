package com.umc.umc.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MissionCreateRes {
    private Long missionId;
    private String title;
    private String content;
    private LocalDateTime createTime;
}
