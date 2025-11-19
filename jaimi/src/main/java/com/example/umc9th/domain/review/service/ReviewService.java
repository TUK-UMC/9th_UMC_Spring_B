package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.user;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    public void addReview(Long storeId, int rating, String content) {

        // 로그인 없음 → userId=1 고정
        user user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("가게 없음"));

        Review review = Review.builder()
                .rating(rating)
                .content(content)
                .user(user)
                .store(store)
                .build();

        reviewRepository.save(review);
    }
}