package com.example.umc9th.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;   // ERD 기준: id1 (bigint)

    private String sns;
    private String sns_name;
    private String name;
    private String gender;
    private int birth;
    private String address;
    private int point;
    private String account;
}
