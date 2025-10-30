// review/repository/ReviewRepository.java
package com.example.chapter4.domain.review.repository;

import com.example.chapter4.domain.review.dto.MemberReviewDTO;
import com.example.chapter4.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // [리팩토링] image_255d19.png의 "작성한 리뷰" SELECT 쿼리
    /**
     * 특정 회원의 활성화된 리뷰를 DTO로 조회합니다. (최신순)
     * (JPQL은 엔티티 객체 그래프를 탐색하며 조인합니다)
     */
    @Query("SELECT new com.example.chapter4.domain.review.dto.MemberReviewDTO(s.name, m.name, r.rating, r.content, r.createdAt) " +
            "FROM Review r " +
            "JOIN r.menu m " +
            "JOIN m.store s " +
            "WHERE r.member.id = :memberId AND r.status = 'ACTIVE' " +
            "ORDER BY r.createdAt DESC")
    List<MemberReviewDTO> findMyReviews(@Param("memberId") Long memberId);

}