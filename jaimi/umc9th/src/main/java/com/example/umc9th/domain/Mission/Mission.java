package com.example.umc9th.domain.Mission;

import com.example.umc9th.domain.Store.Store;
import jakarta.persistence.*;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private Store store;

    @Column(nullable = false, length = 100)
    private String missionExplain;

    @Column(nullable = false, length = 100)
    private String missionAward;

    @Column(nullable = false, length = 100)
    private String missionProgress;

    @Column
    private int missionStart;

    @Column
    private int missionTime;

    @Column(nullable = false, length = 100)
    private String missionSuccess;

    protected Mission() {}
}
