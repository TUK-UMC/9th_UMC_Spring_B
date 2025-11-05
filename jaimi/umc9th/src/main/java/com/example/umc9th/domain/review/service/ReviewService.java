package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.repository.ReviewRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 서비스 계층
// 비즈니스 로직 담당
// Controller와 Repository 사이 연결

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepositoryImpl reviewRepository;

    // 내가 작성한 리뷰 조회
    public List<ReviewResponseDto> getMyReviews(Long userId, String storeName, Integer starRange) {
        return reviewRepository.findMyReviews(userId, storeName, starRange);
    }
}
