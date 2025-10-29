package com.example.umc9th.domain.Reivew;

import com.example.umc9th.domain.Menu.Menu;
import com.example.umc9th.domain.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id3", nullable = false)
    private Menu menu;

    @Column(nullable = false)
    private float reviewRate;

    @Column(nullable = false, length = 300)
    private String review;

    @Column(nullable = false, length = 200)
    private String reviewPhoto;

    @Column(nullable = false, length = 200)
    private String address;

    protected Review() {}
}
