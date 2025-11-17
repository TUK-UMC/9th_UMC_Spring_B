package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Review 엔티티에 대한 기본 JPA Repository
// save, findById, delete 같은 기본 CRUD 자동 제공
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 가게의 리뷰 조회
    @Query("SELECT r FROM Review r JOIN FETCH r.user u WHERE r.store.id = :storeId")
    List<Review> findByStoreId(@Param("storeId") Long storeId);

    // 특정 사용자가 작성한 리뷰 조회
    @Query("SELECT r FROM Review r JOIN FETCH r.store s WHERE r.user.id = :userId")
    List<Review> findByUserId(@Param("userId") Long userId);
}
