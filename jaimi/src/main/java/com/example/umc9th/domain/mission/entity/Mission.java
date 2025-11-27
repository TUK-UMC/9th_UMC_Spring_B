package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.entity.user;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 가게의 미션인가?
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    // 어떤 사용자의 미션인가?
    @ManyToOne(fetch = FetchType.LAZY)
    private user user;

    private String missionExplain;
    private String missionAward;

    // 진행 상태 enum
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private int missionTimeLimit;
}
