package com.umc.umc.domain.review.entity;

import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double rate;

    private String image;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Review(Long id, String title, Double rate, String image, String content, User user, Store store) {
        this.id = id;
        this.title = title;
        this.rate = rate;
        this.image = image;
        this.content = content;
        this.user = user;
        this.store = store;
    }
}
