package com.umc.umc.domain.user.entity;

import com.umc.umc.domain.Inquiry.entity.Inquiry;
import com.umc.umc.domain.mission.entity.MissionStatus;
import com.umc.umc.domain.notification.entity.Notification;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.user.enums.Gender;
import com.umc.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    private Integer point;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<MissionStatus> missionStatuses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PreferenceFood> preferenceFoods = new ArrayList<>();

    @Builder
    public User(Long id, String name, String email, Gender gender, LocalDate birth, String address, String phoneNumber, Integer point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }
}
