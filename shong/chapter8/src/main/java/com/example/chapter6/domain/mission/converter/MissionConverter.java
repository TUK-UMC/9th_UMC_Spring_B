package com.example.chapter6.domain.mission.converter;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;

import java.time.LocalDateTime;

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
}
