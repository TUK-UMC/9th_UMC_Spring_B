package com.umc.umc.domain.review.entity;

import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
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

    public static Review createReview(User user, Store store, String title, Double rating, String content) {
        Review review = new Review();
        review.setUser(user);
        review.setStore(store);
        review.setTitle(title);
        review.setRate(rating);
        review.setContent(content);
        return review;
    }
}
