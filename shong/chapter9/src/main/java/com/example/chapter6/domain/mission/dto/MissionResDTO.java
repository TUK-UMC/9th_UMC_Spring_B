package com.example.chapter6.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {

    // 미션 수락 응답 DTO
    @Builder
    public record AcceptMissionDTO(
            Long receivedMissionId,
            LocalDateTime acceptedAt
    ) {}

    // ---  가게 미션 목록 조회용 DTO ---
    @Builder
    public record MissionPreViewListDTO(
            List<MissionPreViewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MissionPreViewDTO(
            Long missionId,
            Integer reward,
            LocalDateTime deadline,
            String missionSpec
    ) {}

    // --- 내가 진행중인 미션 목록 조회용 DTO ---
    @Builder
    public record MyMissionPreViewListDTO(
            List<MyMissionPreViewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MyMissionPreViewDTO(
            Long receivedMissionId,
            String storeName, // 가게 이름
            Integer reward,   // 보상
            String status,    // 상태 (진행중/완료)
            String missionSpec, // 미션 내용
            LocalDateTime deadline // 마감 기한
    ) {}

    // --- 미션 완료 응답 DTO ---
    @Builder
    public record MissionCompleteDTO(
            Long receivedMissionId,
            String status,      // 변경된 상태 ("완료")
            Integer reward,     // 획득한 포인트
            LocalDateTime completedAt // 완료 시간
    ) {}

}
