// File: com/example/chapter6/domain/review/repository/ReviewRepository.java
package com.example.chapter6.domain.review.repository;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * [핵심]
 * 1. JpaRepository: save(), findById() 등 기본 메서드를 *자동*으로 만들어줍니다.
 * 2. ReviewRepositoryCustom: findMyReviewsDynamic() 등 *직접 구현할* 메서드를 정의합니다.
 *
 * 이 인터페이스가 두 인터페이스를 함께 상속(extends)하면,
 * Spring Data JPA가 'ReviewRepositoryImpl' 클래스를 찾아
 * (1)번의 '자동 메서드'와 (2)번의 '직접 구현한 메서드'를 하나로 합쳐줍니다.
 */
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    /**
     * 마이 페이지 - 내가 작성한 리뷰 목록 조회 (JPQL - 기존 코드)
     */
    @Query("SELECT new com.example.chapter6.domain.review.dto.MyReviewDTO(s.name, m.name, r.rating, r.content, r.createdAt) " +
            "FROM Review r " +
            "JOIN r.menu m " +
            "JOIN m.store s " +
            "WHERE r.member.id = :memberId AND r.status = 'ACTIVE' " +
            "ORDER BY r.createdAt DESC")
    List<MyReviewDTO> findMyReviews(@Param("memberId") Long memberId);

    // findMyReviewsDynamic(...) 메서드 선언은
    // 부모인 ReviewRepositoryCustom에 이미 있으므로
    // 여기에 또 적을 필요가 없습니다.
}
