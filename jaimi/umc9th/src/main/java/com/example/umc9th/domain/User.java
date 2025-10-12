package com.example.umc9th.domain;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @Column(nullable = false, length = 20)
    private String sns;

    @Column(nullable = false, length = 50)
    private String snsName;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false)
    private int birth;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false, length = 50)
    private String account;

    // 연관 관계
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notice> notices = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PreferenceFood> preferences = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PersonalMission> personalMissions = new ArrayList<>();

    protected User() {}
}
