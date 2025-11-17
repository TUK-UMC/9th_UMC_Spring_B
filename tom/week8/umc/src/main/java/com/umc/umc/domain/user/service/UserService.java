package com.umc.umc.domain.user.service;

import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<MyReviewDto> getMyReviews(Long userId, MyReviewSearchCond cond, Pageable pageable);
}
