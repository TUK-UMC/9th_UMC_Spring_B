package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.exception.UserException;
import com.umc.umc.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final ReviewRepository reviewRepository;

    public Page<MyReviewDto> getMyReviews(Long userId, MyReviewSearchCond cond,  Pageable pageable) {

        Page<MyReviewDto> myReviews = reviewRepository.findMyReviews(userId, cond, pageable);
//        if (myReviews.isEmpty()) {
//            throw new UserException(GeneralErrorCode.INTERNAL_SERVER_ERROR); // 예외처리 테스트를 위해서 추가
//        }
        return myReviews;
    }
}
