package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.review.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<MyReviewDto> getMyReviews(Long userId, MyReviewSearchCond cond, Pageable pageable);

    // 회원가입
    UserResDto signup(
            UserReqDto dto
    );

    MyReviewDto.ReviewListDto getMyReviews(Long userId, Integer page);
}
