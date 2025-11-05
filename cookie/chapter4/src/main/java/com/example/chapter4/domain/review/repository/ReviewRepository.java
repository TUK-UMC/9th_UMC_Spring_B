package com.example.chapter4.domain.review.repository;

import com.example.chapter4.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

    // 특정 회원의 활성화된 리뷰 목록 조회 (작성일 기준 내림차순)
    @Query("SELECT r FROM Review r WHERE r.member.id = :memberId AND r.status = 'ACTIVE' ORDER BY r.createdAt DESC")
    List<Review> findActiveReviewsByMemberId(@Param("memberId") Long memberId);

    // 필요한 JPQL 쿼리를 추가로 작성 가능
}
