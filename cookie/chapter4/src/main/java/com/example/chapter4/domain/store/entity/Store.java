package com.example.chapter4.domain.store.entity;

import com.example.chapter4.global.entity.BaseEntity;
import com.example.chapter4.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


// 가게 정보를 나타내는 엔티티입니다.

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String description;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    private LocalDateTime openTime;

    @Column(length = 15)
    private String status;

    private Float rating; // 가게 평균 평점

    // Store는 하나의 Area에 속한다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    // Store는 여러개의 Mission을 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    // Store는 여러개의 Menu를 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menuList = new ArrayList<>();
}