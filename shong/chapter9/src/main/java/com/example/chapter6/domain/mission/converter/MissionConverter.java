package com.example.chapter6.domain.mission.converter;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    // ReceivedMission -> AcceptMissionDTO 변환
    public static MissionResDTO.AcceptMissionDTO toAcceptMissionDTO(ReceivedMission receivedMission) {
        return MissionResDTO.AcceptMissionDTO.builder()
                .receivedMissionId(receivedMission.getId())
                // BaseEntity의 createdAt은 자동으로 생성되므로, 수락 시점을 나타냅니다.
                .acceptedAt(receivedMission.getCreatedAt())
                .build();
    }

    // Member + Mission -> ReceivedMission 엔티티 생성
    public static ReceivedMission toReceivedMission(Member member, Mission mission) {

        // Mission 엔티티의 validDays(유효 일수)를 이용해 마감 기한을 계산합니다.
        // Mission.java: private Integer validDays; 필드를 사용합니다.
        LocalDateTime deadline = LocalDateTime.now().plusDays(mission.getValidDays());

        return ReceivedMission.builder()
                .member(member)
                .mission(mission)
                .status("진행중") // 미션 수락 시 초기 상태는 '진행중'
                .deadline(deadline)
                .build();
    }

    // --- 목록 조회 변환 로직 ---

    // 1. 개별 Mission -> DTO 변환
    public static MissionResDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission) {
        return MissionResDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getCreatedAt().plusDays(mission.getValidDays())) // 생성일 + 유효기간 = 마감일
                .missionSpec(mission.getTitle()) // 제목 또는 설명
                .build();
    }

    // 2. Page<Mission> -> ListDTO 변환 (Stream 사용)
    public static MissionResDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionPage) {
        List<MissionResDTO.MissionPreViewDTO> missionPreViewDTOList = missionPage.getContent().stream()
                .map(MissionConverter::toMissionPreViewDTO)
                .collect(Collectors.toList());

        return MissionResDTO.MissionPreViewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    // --- 내 미션 목록 조회 변환 로직 ---

    // 1. 개별 ReceivedMission -> MyMissionPreViewDTO 변환
    public static MissionResDTO.MyMissionPreViewDTO toMyMissionPreViewDTO(ReceivedMission receivedMission) {
        return MissionResDTO.MyMissionPreViewDTO.builder()
                .receivedMissionId(receivedMission.getId())
                // ReceivedMission -> Mission -> Store 이름 접근
                .storeName(receivedMission.getMission().getStore().getName())
                .reward(receivedMission.getMission().getReward())
                .status(receivedMission.getStatus())
                .missionSpec(receivedMission.getMission().getTitle()) // 미션 제목
                .deadline(receivedMission.getDeadline())
                .build();
    }

    // 2. Page<ReceivedMission> -> MyMissionPreViewListDTO 변환 (Stream 사용)
    public static MissionResDTO.MyMissionPreViewListDTO toMyMissionPreViewListDTO(Page<ReceivedMission> page) {
        List<MissionResDTO.MyMissionPreViewDTO> myMissionDTOList = page.getContent().stream()
                .map(MissionConverter::toMyMissionPreViewDTO)
                .collect(Collectors.toList());

        return MissionResDTO.MyMissionPreViewListDTO.builder()
                .isLast(page.isLast())
                .isFirst(page.isFirst())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .listSize(myMissionDTOList.size())
                .missionList(myMissionDTOList)
                .build();
    }

    // --- 완료된 미션 -> 응답 DTO 변환 ---
    public static MissionResDTO.MissionCompleteDTO toMissionCompleteDTO(ReceivedMission receivedMission) {
        return MissionResDTO.MissionCompleteDTO.builder()
                .receivedMissionId(receivedMission.getId())
                .status(receivedMission.getStatus()) // "완료"
                .reward(receivedMission.getMission().getReward()) // 획득 포인트
                .completedAt(LocalDateTime.now()) // 현재 시각
                .build();
    }

}
