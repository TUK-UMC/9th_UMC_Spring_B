package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final ReviewRepository reviewRepository;

    public Page<MyReviewDto> getMyReviews(Long userId, MyReviewSearchCond cond,  Pageable pageable) {
        return reviewRepository.findMyReviews(userId, cond, pageable);
    }
}
