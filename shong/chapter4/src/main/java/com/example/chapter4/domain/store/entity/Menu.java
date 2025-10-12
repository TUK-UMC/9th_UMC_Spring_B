package com.example.chapter4.domain.store.entity;

import com.example.chapter4.global.entity.BaseEntity;
import com.example.chapter4.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


// 가게의 메뉴 정보를 나타내는 엔티티입니다.

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private Integer price;

    private String image; // 이미지 URL 저장

    private Float rating; // 메뉴 평균 평점

    // Menu는 하나의 Store에 속한다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // Menu는 여러개의 Review를 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}