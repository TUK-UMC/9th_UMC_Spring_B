package com.umc.umc.domain.mission.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionCreateReq {
    private String title;
    private String description;
}
