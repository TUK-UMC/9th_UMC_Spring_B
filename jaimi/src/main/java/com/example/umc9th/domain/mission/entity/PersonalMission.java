package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.user.entity.user;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "personal_mission")
public class PersonalMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1")   // ERD: user.id1
    private user user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2")   // ERD: mission.id1
    private mission mission;

    private int time;

    @Builder
    public PersonalMission(user user, mission mission, int time) {
        this.user = user;
        this.mission = mission;
        this.time = time;
    }
}
