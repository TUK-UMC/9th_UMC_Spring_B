package com.example.domain.mission.entity;

import com.example.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Mission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String missionExplain;   // 미션 설명
    private int missionAward;        // 보상 포인트
    private String missionSuccess;   // 성공여부 상태 등

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
