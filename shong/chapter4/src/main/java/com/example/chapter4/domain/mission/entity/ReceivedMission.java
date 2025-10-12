package com.example.chapter4.domain.mission.entity;

import com.example.chapter4.global.entity.BaseEntity;
import com.example.chapter4.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 사용자가 받은 미션의 진행 상태를 나타내는 엔티티입니다.
 */
@Entity
@Table(name = "received_mission") // DB 테이블명을 'received_mission'으로 명시적으로 지정
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReceivedMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String status; // 미션 상태 (e.g., "진행중", "완료")

    private LocalDateTime deadline; // 미션 마감 시간

    // ReceivedMission은 하나의 Member를 가진다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // ReceivedMission은 하나의 Mission을 가진다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}