package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.Gender;
import com.example.umc9th.global.auth.enums.Role;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,  length = 20)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth;

    private String address;

    private String detailAddress;
}
