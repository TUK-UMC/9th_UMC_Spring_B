package com.example.chapter6.domain.review.service.query;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<MyReviewDTO> getMyReviews(Long memberId, String storeName, Integer ratingFilter) {

        // Repository의 QueryDSL 메서드를 호출합니다.
        // 이 로직은 데이터가 없어도 예외가 아닌 빈 리스트 '[]'를 반환하는 것이
        // 올바른 비즈니스 로직이므로, 예외 처리가 필요 없다.
        return reviewRepository.findMyReviewsDynamic(memberId, storeName, ratingFilter);
    }
}