package com.example.umc9th.domain.mission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "mission")

public class mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    private Long id2; // store id
    private String mission_explain;
    private String mission_award;
    private int mission_progress;
    private int mission_start;
    private int mission_time;
    private String mission_success;
}
