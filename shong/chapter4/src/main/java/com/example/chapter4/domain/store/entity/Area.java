package com.example.chapter4.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 지역 정보를 나타내는 엔티티입니다.
 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name; // 지역 이름 (e.g., "강남구")

    @Column(length = 30)
    private String address; // 주소

    // Area는 여러개의 Store를 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}