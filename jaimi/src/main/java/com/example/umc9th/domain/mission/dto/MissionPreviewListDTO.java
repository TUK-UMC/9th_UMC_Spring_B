package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class MissionPreviewListDTO {
    private List<MissionPreViewDTO> missions;
}
