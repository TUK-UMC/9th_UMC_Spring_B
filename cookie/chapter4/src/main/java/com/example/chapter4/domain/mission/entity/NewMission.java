package com.example.chapter4.domain.mission.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "New_mission")
public class NewMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alrimId;
    private Long memberId;

    @Column(length = 100)
    private String description;
}
