package com.example.chapter4.domain.Alarm.entity;


import jakarta.persistence.*;
import lombok.*;

// 리뷰 관련 알림의 상세 내용을 담는 엔티티.
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

    // 여러개의 리뷰알림(ReviewAlarm)이 하나의 알림(Alarm)에 속함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;

}