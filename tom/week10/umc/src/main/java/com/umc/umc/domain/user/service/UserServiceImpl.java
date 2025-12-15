package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.converter.ReviewConverter;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.user.converter.UserConverter;
import com.umc.umc.domain.review.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.CustomUserDetails;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.enums.Role;
import com.umc.umc.domain.user.exception.UserException;
import com.umc.umc.domain.user.exception.code.UserErrorCode;
import com.umc.umc.domain.user.repository.UserRepository;
import com.umc.umc.global.apiPayload.code.GeneralErrorCode;
import com.umc.umc.global.auth.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private static final int PAGE_SIZE = 10;

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewConverter reviewConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserConverter userConverter;

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
        String salt = passwordEncoder.encode(dto.getPassword());
        // 사용자 생성
        User user = UserConverter.toUser(dto, salt, Role.ROLE_USER);
        // DB 적용
        userRepository.save(user);

        // 응답 DTO 생성
        return UserConverter.toJoinDTO(user);
    }

    @Override
    public MyReviewDto.ReviewListDto getMyReviews(Long userId, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page - 1, PAGE_SIZE);

        Page<Review> reviewPage = reviewRepository.findAllByUser(user, pageRequest);

        return reviewConverter.toReviewListDto(reviewPage);
    }

    @Override
    public UserResDto.LoginDto login(
            UserReqDto.@Valid LoginDto dto) {
        // Member 조회
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        // 비밀번호 검증
        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new UserException(UserErrorCode.INVALID);
        }

        // JWT 토큰 발급용 UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(user);

        // 엑세스 토큰 발급
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // DTO 조립
        return userConverter.toLoginDTO(user, accessToken);
    }


}
