package com.example.umc9th.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "review_notice")
public class ReviewNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id3", nullable = false)
    private Review review;

    @Column(nullable = false, length = 200)
    private String head;

    @Column(nullable = false, length = 500)
    private String body;

    protected ReviewNotice() {}
}
