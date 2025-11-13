package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.user.dto.MyPageResponseDto;
import com.example.umc9th.domain.user.dto.MyReviewDto;
import com.example.umc9th.domain.user.entity.user;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public MyPageResponseDto getMyPage(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        List<Review> reviews = reviewRepository.findByUserId(userId);

        List<MyReviewDto> reviewDtos = reviews.stream()
                .map(r -> new MyReviewDto(
                        r.getStore().getName(),
                        r.getReviewContent(),
                        r.getReviewRate(),
                        r.getCreatedDate().toLocalDate().toString()
                ))
                .collect(Collectors.toList());

        return new MyPageResponseDto(
                user.getName(),
                user.getEmail(),
                user.getPoint(),
                reviewDtos
        );
    }
}
