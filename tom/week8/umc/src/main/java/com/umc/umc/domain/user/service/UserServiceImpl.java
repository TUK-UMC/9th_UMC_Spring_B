package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.user.converter.UserConverter;
import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.entity.PreferenceFood;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.exception.UserException;
import com.umc.umc.domain.user.repository.UserRepository;
import com.umc.umc.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<MyReviewDto> getMyReviews(Long userId, MyReviewSearchCond cond,  Pageable pageable) {

        Page<MyReviewDto> myReviews = reviewRepository.findMyReviews(userId, cond, pageable);
        if (myReviews.isEmpty()) {
            throw new UserException(GeneralErrorCode.INTERNAL_SERVER_ERROR); // 예외처리 테스트를 위해서 추가
        }
        return myReviews;
    }

    // 회원가입
    @Override
    public UserResDto signup(
            UserReqDto dto
    ){
        // 사용자 생성
        User user = UserConverter.toUser(dto);
        // DB 적용
        userRepository.save(user);

        // 응답 DTO 생성
        return UserConverter.toJoinDTO(user);
    }
}
