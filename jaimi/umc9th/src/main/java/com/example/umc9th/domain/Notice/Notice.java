package com.example.umc9th.domain.Notice;

import com.example.umc9th.domain.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1", nullable = false)
    private User user;

    @Column(nullable = false)
    private int missionCreate;

    @Column(nullable = false)
    private int missionSuccess;

    protected Notice() {}
}
