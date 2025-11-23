package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.MissionStatus;
import com.example.umc9th.domain.mission.dto.MissionPreViewDTO;
import com.example.umc9th.domain.mission.dto.MissionPreviewListDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MissionConverter {

    public MissionPreViewDTO toPreviewDTO(Mission mission){
        return MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .missionExplain(mission.getMissionExplain())
                .missionAward(mission.getMissionAward())
                .storeName(mission.getStore().getName())
                .userName(mission.getUser().getName())
                .status(mission.getStatus())
                .build();
    }
    public MissionPreviewListDTO toPreviewList(List<Mission> missionList){
        return MissionPreviewListDTO.builder()
                .missions(
                        missionList.stream()
                                .map(this::toPreviewDTO)
                                .toList()
                )
                .build();
    }
}
