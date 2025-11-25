package com.umc.umc.domain.review.repository;

import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryQueryDsl {
    Page<MyReviewDto> findMyReviews(Long userId, MyReviewSearchCond cond, Pageable pageable);
}
