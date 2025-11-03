package com.example.chapter4.domain.member.entity;

import com.example.chapter4.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Preference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Preference는 하나의 Member를 가진다. (N:1 관계)
    // fetch = FetchType.LAZY: 지연 로딩. 실제 Member 객체가 필요할 때까지 데이터베이스에서 조회하지 않습니다. (성능 최적화)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 외래 키(FK) 컬럼을 'member_id'로 지정합니다.
    private Member member;

    // Preference는 하나의 Food를 가진다. (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;
}