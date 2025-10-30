package com.example.chapter4.domain.review.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CopyOfReview")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private Integer rating;
    private String content;
    private String photo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
