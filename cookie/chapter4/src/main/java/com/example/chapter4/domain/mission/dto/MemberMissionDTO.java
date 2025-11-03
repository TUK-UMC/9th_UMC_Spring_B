// mission/dto/MemberMissionDTO.java
package com.example.chapter4.domain.mission.dto; // (패키지 경로는 예시입니다)

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class MemberMissionDTO {

    private Integer reward; // (DB 타입에 따라 Integer, String 등)
    private String storeName;
    private String description;
    private String status;
    private LocalDateTime updatedAt;

    // [핵심]
    // Repository의 @Query가 이 생성자를 호출하여 DTO를 바로 만듭니다.
    public MemberMissionDTO(Integer reward, String storeName, String description, String status, LocalDateTime updatedAt) {
        this.reward = reward;
        this.storeName = storeName;
        this.description = description;
        this.status = status;
        this.updatedAt = updatedAt;
    }
}