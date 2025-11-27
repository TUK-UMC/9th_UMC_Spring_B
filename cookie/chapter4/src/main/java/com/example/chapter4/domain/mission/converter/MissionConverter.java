package com.example.chapter4.domain.mission.converter;

import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;
import com.example.chapter4.domain.mission.dto.MissionResDto;
import com.example.chapter4.domain.mission.entity.Mission;
import com.example.chapter4.domain.mission.entity.ReceivedMission;
import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.store.entity.Store;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static ReceivedMission toReceivedMission(MissionChallengeReqDTO dto, Mission mission, Member member) {
        return ReceivedMission.builder()
                .mission(mission)
                .member(member)
                .status("IN_PROGRESS") // 초기 상태
                .deadline(LocalDateTime.now().plusDays(7)) // 임의 마감일(예시)
                .build();
    }

    public static MissionChallengeResDTO toChallengeResDTO(ReceivedMission receivedMission) {
        Mission mission = receivedMission.getMission();
        Store store = mission.getStore();
        return MissionChallengeResDTO.builder()
                .receivedMissionId(receivedMission.getId())
                .missionId(mission.getId())
                .storeId(store.getId())
                .memberId(receivedMission.getMember().getId())
                .status(receivedMission.getStatus())
                .build();
    }

    public static MissionChallengeResDTO toChallengeResDTO(Mission mission) {
        return null;
    }
    public static MissionResDto toResDto(Mission mission) {
        return MissionResDto.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .build();
    }
    public static List<MissionResDto> toResDtoList(List<Mission> missions) {
        return missions.stream()
                .map(MissionConverter::toResDto)
                .collect(Collectors.toList());
    }
}
