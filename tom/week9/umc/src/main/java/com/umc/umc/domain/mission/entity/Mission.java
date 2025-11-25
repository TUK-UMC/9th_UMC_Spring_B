package com.umc.umc.domain.mission.entity;

import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "mission")
    private List<MissionStatus> missionStatuses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Mission(String title, String description, Store store) {
        this.title = title;
        this.description = description;
        this.store = store;
    }

}
