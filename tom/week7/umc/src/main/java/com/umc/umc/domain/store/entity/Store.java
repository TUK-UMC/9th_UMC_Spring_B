package com.umc.umc.domain.store.entity;

import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Mission> missions = new ArrayList<>();

    @Builder
    public Store(Long id, String name, String address, String description, Region region) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.region = region;
    }
}
