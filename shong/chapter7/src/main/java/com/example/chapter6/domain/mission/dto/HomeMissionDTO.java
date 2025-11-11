package com.example.chapter6.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HomeMissionDTO {
    private Long missionId;         // m.id
    private String storeName;       // s.name
    private String storeCategory;   // s.description (가게 카테고리)
    private String missionDescription; // m.description
    private Integer missionReward;  // m.reward (엔티티에 추가 필요)
}