// mission/dto/MyMissionDTO.java
package com.example.chapter4.domain.mission.dto; // (패키지 경로는 예시입니다)

import lombok.Getter;
import java.time.LocalDate; // (deadline 타입이 LocalDate라고 가정)

@Getter
public class MyMissionDTO {

    private Long missionId;
    private String storeName;
    private String storeCategory;
    private String missionDescription;
    private Integer missionReward; // (reward 타입이 Integer라고 가정)
    private LocalDate missionDeadline; // (항상 null이 될 것임)

    // [핵심] Repository의 @Query가 이 생성자를 호출
    public MyMissionDTO(Long missionId, String storeName, String storeCategory,
                        String missionDescription, Integer missionReward, LocalDate missionDeadline) {
        this.missionId = missionId;
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.missionDescription = missionDescription;
        this.missionReward = missionReward;
        this.missionDeadline = missionDeadline;
    }
}