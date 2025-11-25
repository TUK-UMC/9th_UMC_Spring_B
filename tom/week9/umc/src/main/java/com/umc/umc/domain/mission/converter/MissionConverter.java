package com.umc.umc.domain.mission.converter;

import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.dto.res.MissionResponseDto;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.entity.MissionStatus;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionConverter {

    public Mission toMission(MissionCreateReq request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .store(store)
                .build();
    }

    public MissionCreateRes toMissionCreateRes(Mission mission) {
        return new MissionCreateRes(
                mission.getId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getCreateTime()
        );
    }

    public MissionStatus toMissionStatus(User user, Mission mission) {
        return MissionStatus.builder()
                .user(user)
                .mission(mission)
                .status("ONGOING")
                .build();
    }

    public MissionChallengeRes toMissionChallengeResponse(MissionStatus missionStatus) {
        return new MissionChallengeRes(
                missionStatus.getId(),
                missionStatus.getStatus(),
                missionStatus.getCreateTime()
        );
    }

    public MissionResponseDto.MissionDto toMissionDto(Mission mission) {
        return MissionResponseDto.MissionDto.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .createTime(mission.getCreateTime())
                .build();
    }

    public MissionResponseDto.MissionListDto toMissionListDto(Page<Mission> missionPage) {
        List<MissionResponseDto.MissionDto> missionDtoList = missionPage.stream()
                .map(this::toMissionDto)
                .collect(Collectors.toList());

        return MissionResponseDto.MissionListDto.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .listSize(missionPage.getSize())
                .missionList(missionDtoList)
                .build();
    }

    public MissionResponseDto.OngoingMissionDto toOngoingMissionDto (MissionStatus missionStatus) {
        return MissionResponseDto.OngoingMissionDto.builder()
                .missionId(missionStatus.getMission().getId())
                .title(missionStatus.getMission().getTitle())
                .description(missionStatus.getMission().getDescription())
                .status("ONGOING")
                .completionTime(missionStatus.getMission().getUpdateTime())
                .build();
    }

    public MissionResponseDto.OnGoingListDto toOnGoingListDto (Page<MissionResponseDto.OngoingMissionDto> missionPage) {

        return MissionResponseDto.OnGoingListDto.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .listSize(missionPage.getSize())
                .ongoingMissionList(missionPage.getContent())
                .build();
    }

}
