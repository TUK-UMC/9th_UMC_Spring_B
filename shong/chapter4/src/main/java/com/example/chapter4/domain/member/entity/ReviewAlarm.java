package com.example.chapter4.domain.member.entity;


import jakarta.persistence.*;
import lombok.*;

/**
 * 리뷰 관련 알림의 상세 내용을 담는 엔티티입니다.
 */
@Entity
@Table(name = "review_alarm")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    // ReviewAlarm은 상위 알림(Alarm)에 속합니다. (1:1 관계, FK 보유)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;

}