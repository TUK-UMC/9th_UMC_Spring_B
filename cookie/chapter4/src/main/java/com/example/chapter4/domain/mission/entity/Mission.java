package com.example.chapter4.domain.mission.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean status;

    @Column(length = 100)
    private String description;

    private Long storeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
