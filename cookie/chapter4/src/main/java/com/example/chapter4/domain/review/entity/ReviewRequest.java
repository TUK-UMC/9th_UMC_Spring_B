package com.example.chapter4.domain.review.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Review_request")
public class ReviewRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alrimId;
    private Long memberId;

    @Column(length = 100)
    private String description;
}
