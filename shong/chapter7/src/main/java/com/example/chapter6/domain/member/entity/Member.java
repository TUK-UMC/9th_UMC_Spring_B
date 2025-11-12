package com.example.chapter6.domain.member.entity;

import com.example.chapter6.domain.Alarm.entity.Alarm;
import com.example.chapter6.global.entity.BaseEntity;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import com.example.chapter6.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter // Lombok: 모든 필드에 대한 getter 메서드를 자동으로 생성합니다.
@Builder // Lombok: 빌더 패턴을 사용할 수 있게 합니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok: 파라미터가 없는 기본 생성자를 생성합니다. (PROTECTED: 무분별한 객체 생성을 방지)
@AllArgsConstructor // Lombok: 모든 필드를 인자로 받는 생성자를 생성합니다.

public class Member extends BaseEntity {

    @Id // 이 필드가 테이블의 기본 키(PK)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임합니다. (e.g., MySQL의 AUTO_INCREMENT)
    private Long id;

    @Column(nullable = false, length = 20) // 데이터베이스 컬럼에 매핑됩니다. nullable=false는 NOT NULL 제약조건을 의미합니다.
    private String email;

    @Column(length = 10)
    private String provider; // 소셜 로그인 제공자 (e.g., "kakao", "google")

    @Column(name = "provider_user_id", length = 30) // ERD의 컬럼명과 필드명이 다를 때 name 속성으로 지정
    private String providerUserId; // 소셜 로그인 사용자의 고유 ID

    @Column(nullable = false, length = 10)
    private String name;

    @Column(length = 10)
    private String gender;

    private LocalDate birth; // 생년월일

    @Column(length = 100)
    private String address;

    @Column(columnDefinition = "integer default 0") // 컬럼의 기본값을 0으로 설정합니다.
    private Integer point;

    @Column(length = 15)
    private String status; // 회원 상태 (e.g., "ACTIVE", "INACTIVE")

    private LocalDateTime inactiveDate; // 비활성화된 날짜

    @Column(length = 5)
    private String isVerified; // 인증 여부

    // Member는 여러개의 Preference를 가질 수 있다. (1:N 관계)
    // mappedBy = "member": Preference 엔티티의 'member' 필드에 의해 매핑됨을 의미합니다. (이 엔티티가 관계의 주인이 아님)
    // cascade = CascadeType.ALL: Member 엔티티의 생명주기(저장, 삭제 등) 변경이 Preference에도 전파됩니다.
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Preference> preferenceList = new ArrayList<>();

    // Member는 여러개의 ReceivedMission을 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ReceivedMission> receivedMissionList = new ArrayList<>();

    // Member는 여러개의 Review를 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    // Member는 여러개의 Alarm을 가질 수 있다. (1:N 관계)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();
}