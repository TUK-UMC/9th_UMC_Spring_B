package com.example.umc9th.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private Store store;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(name = "explain", nullable = false, length = 100)
    private String explain;

    @Column(nullable = false)
    private float rate;

    @Column(nullable = false, length = 200)
    private String photo;

    protected Menu() {}
}
