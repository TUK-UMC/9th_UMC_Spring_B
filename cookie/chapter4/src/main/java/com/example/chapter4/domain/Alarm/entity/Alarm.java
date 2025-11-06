package com.example.chapter4.domain.Alarm.entity;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;


// 회원에게 발생하는 모든 알림의 공통 정보를 담는 엔티티.

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isConfirmed; // 사용자가 알림을 확인했는지 여부

    // 알림은 특정 회원에게 속합니다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 하나의 알림(Alarm)이 여러개의 미션알림(MissionAlarm)을 가질 수 있음
    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<MissionAlarm> missionAlarmList = new ArrayList<>();

    // 하나의 알림(Alarm)이 여러개의 리뷰알림(ReviewAlarm)을 가질 수 있음
    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<ReviewAlarm> reviewAlarmList = new ArrayList<>();
}