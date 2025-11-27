package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDto.ReviewPreViewListDTO getMyReviews(Long userId, int page) {

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        Page<Review> result = reviewRepository.findAllByUserId(userId, pageRequest);

        return ReviewConverter.toReviewPreViewListDTO(result);
    }
}