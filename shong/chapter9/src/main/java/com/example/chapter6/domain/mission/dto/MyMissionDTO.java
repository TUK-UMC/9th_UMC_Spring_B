package com.example.chapter6.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor // JPQL의 'new' 키워드는 생성자를 호출합니다.
public class MyMissionDTO {
    private Integer reward;       // m.reward (Mission)
    private String storeName;     // s.name (Store)
    private String description;   // m.description (Mission)
    private String status;        // rm.status (ReceivedMission)
    private LocalDateTime updatedAt;  // rm.updated_at (ReceivedMission -> BaseEntity)
}