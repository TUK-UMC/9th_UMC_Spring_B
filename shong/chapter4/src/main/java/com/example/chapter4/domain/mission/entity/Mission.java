package com.example.chapter4.domain.mission.entity;


import com.example.chapter4.global.entity.BaseEntity;
import com.example.chapter4.domain.mission.entity.ReceivedMission;
import com.example.chapter4.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


//가게에서 제공하는 미션 정보를 나타내는 엔티티입니다.

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String description;

    @Column(nullable = false, length = 30)
    private String title;

    // Mission은 하나의 Store에 속한다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // Mission은 여러개의 ReceivedMission을 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<ReceivedMission> receivedMissionList = new ArrayList<>();

}