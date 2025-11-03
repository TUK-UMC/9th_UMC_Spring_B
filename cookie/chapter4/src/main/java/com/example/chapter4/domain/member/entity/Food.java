package com.example.chapter4.domain.member.entity;

import com.example.chapter4.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


// 회원이 선호하는 음식 종류(카테고리) 정보를 나타내는 엔티티입니다.
// 회원의 취향을 관리하는 member 도메인에 포함됩니다.

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name; // 음식 종류 이름 (e.g., "한식", "중식", "일식")

    @Column(length = 100)
    private String description;

    // Food는 여러 회원의 선호(Preference) 대상이 될 수 있습니다. (1:N 관계)
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Preference> preferenceList = new ArrayList<>();
}