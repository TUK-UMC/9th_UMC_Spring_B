package com.umc.umc.domain.review.repository;

import com.umc.umc.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r " +
            "join fetch r.store s " +
            "where r.user.id =: userId " +
            "order by r.createTime desc")
    List<Review> findReviewsWithStoreByUserId(@Param("userId") Long userId);
}

