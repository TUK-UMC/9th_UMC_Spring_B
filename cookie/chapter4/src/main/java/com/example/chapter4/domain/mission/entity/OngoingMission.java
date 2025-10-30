package com.example.chapter4.domain.mission.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ongoing_mission")
public class OngoingMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long missionId;
    private Long memberId;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
