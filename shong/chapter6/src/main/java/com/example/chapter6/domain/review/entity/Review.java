package com.example.chapter6.domain.review.entity;

import com.example.chapter6.global.entity.BaseEntity;
import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.store.entity.Menu;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 메뉴에 대한 리뷰 정보를 나타내는 엔티티입니다.
 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float rating; // 평점

    @Column(columnDefinition = "TEXT") // 긴 텍스트를 저장할 수 있는 TEXT 타입으로 매핑
    private String content;

    @Column(length = 200)
    private String photo; // 사진 URL

    @Column(length = 15)
    private String status;

    private LocalDateTime inactiveDate;

    // Review는 하나의 Member에 의해 작성된다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Review는 하나의 Menu에 대해 작성된다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public static Review createReview(Member member, Menu menu, Float rating, String content, String photo) {
        return Review.builder()
                .member(member)
                .menu(menu)
                .rating(rating)
                .content(content)
                .photo(photo)
                .status("ACTIVE") // 기본값 설정
                .build();
    }

}