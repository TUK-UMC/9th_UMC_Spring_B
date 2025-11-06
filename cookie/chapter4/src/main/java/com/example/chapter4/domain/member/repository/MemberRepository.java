package com.example.chapter4.domain.member.repository;

import com.example.chapter4.domain.member.dto.MemberProfileDTO;
import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 회원 마이페이지 정보 조회
    @Query("SELECT new com.example.chapter4.domain.member.dto.MemberProfileDTO(" +
            "m.name, m.email, m.isVerified, m.point) " +
            "FROM Member m WHERE m.id = :memberId")
    MemberProfileDTO findProfileByMemberId(@Param("memberId") Long memberId);

    // 작성한 리뷰 목록 조회
    @Query("SELECT r FROM Review r WHERE r.member.id = :memberId AND r.status = 'ACTIVE' ORDER BY r.createdAt DESC")
    List<Review> findReviewsByMemberId(@Param("memberId") Long memberId);

}
