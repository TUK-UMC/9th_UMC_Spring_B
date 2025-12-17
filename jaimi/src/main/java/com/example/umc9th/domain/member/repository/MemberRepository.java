package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member; // Member 엔티티 경로 확인
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 이메일로 Member를 조회하는 메서드 정의
    Optional<Member> findByEmail(String email);
}