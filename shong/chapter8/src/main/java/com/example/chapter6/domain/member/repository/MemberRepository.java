package com.example.chapter6.domain.member.repository;

import com.example.chapter6.domain.member.dto.MyPageInfoDTO;
import com.example.chapter6.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * 마이 페이지 - 메인 정보 조회
     * (SQL: SELECT m.name, m.email, m.is_verified, m.point FROM...)
     */
    @Query("SELECT new com.example.chapter6.domain.member.dto.MyPageInfoDTO(m.name, m.email, m.isVerified, m.point) " +
            "FROM Member m " +
            "WHERE m.id = :memberId")
    Optional<MyPageInfoDTO> findMyPageInfo(@Param("memberId") Long memberId);
}