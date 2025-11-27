package com.example.chapter6.domain.review.converter;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;
import com.example.chapter6.domain.review.entity.Review;
import com.example.chapter6.domain.store.entity.Menu;

public class ReviewConverter {

    // DTO -> Entity 변환
    public static Review toReview(ReviewReqDTO.CreateReviewDTO dto, Member member, Menu menu) {
        return Review.builder()
                .rating(dto.rating())
                .content(dto.content())
                .photo(dto.photo())
                .status("ACTIVE")
                .member(member)
                .menu(menu)
                .build();
    }

    // Entity -> DTO 변환
    public static ReviewResDTO.CreateReviewDTO toCreateReviewDTO(Review review) {
        return ReviewResDTO.CreateReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }


}
