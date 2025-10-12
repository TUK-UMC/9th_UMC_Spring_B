package com.example.umc9th.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_mission")
public class PersonalMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1", nullable = false)
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id3", nullable = false)
    private Store store;

    @Column
    private int time;

    protected PersonalMission() {}
}
