package com.example.chapter4.domain.member.entity;

import com.example.chapter4.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 회원에게 발생하는 모든 알림의 공통 정보를 담는 엔티티입니다.
 * 회원의 하위 정보로 간주하여 member 도메인에 포함됩니다.
 */
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

    // 이 알림이 미션 알림인 경우, 해당 상세 정보를 가집니다. (1:1)
    @OneToOne(mappedBy = "alarm", cascade = CascadeType.ALL)
    private MissionAlarm missionAlarm;

    // 이 알림이 리뷰 알림인 경우, 해당 상세 정보를 가집니다. (1:1)
    @OneToOne(mappedBy = "alarm", cascade = CascadeType.ALL)
    private ReviewAlarm reviewAlarm;
}