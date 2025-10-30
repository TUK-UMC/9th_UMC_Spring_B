package com.example.chapter4.domain.member.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 255)
    private String email;

    @Column(length = 20)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(length = 10)
    private String status;

    private LocalDateTime inactiveDate;

    @Column(length = 20)
    private String dateBirth;

    @Column(length = 100)
    private String adress;

    private Integer point;
}
