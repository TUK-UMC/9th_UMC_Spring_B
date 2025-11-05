package com.example.domain.review.entity;

import com.example.domain.store.entity.Store;
import com.example.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;       // 리뷰 내용
    private Float star;           // 별점
    private String reply;         // 사장님 답글 (nullable)
    private LocalDateTime createdDate = LocalDateTime.now(); // 작성일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
