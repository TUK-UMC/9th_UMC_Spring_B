package com.example.chapter4.domain.store.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;    // 상점 이름
    private String adress;  // 상점 주소

    // getter, setter 등 필요에 따라 추가
}
