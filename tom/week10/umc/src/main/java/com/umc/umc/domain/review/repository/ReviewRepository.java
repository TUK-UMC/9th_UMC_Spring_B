package com.umc.umc.domain.review.repository;

import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryQueryDsl {
    @Query("select r from Review r " +
            "join fetch r.store s " +
            "where r.user.id =: userId " +
            "order by r.createTime desc")
    List<Review> findReviewsWithStoreByUserId(@Param("userId") Long userId);

    Page<Review> findAllByUser(User user, Pageable pageable);
}

