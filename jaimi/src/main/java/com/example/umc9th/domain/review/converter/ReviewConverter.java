package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReviewConverter {

    // Page<Review> → ReviewPreViewListDTO 변환
    public static ReviewResponseDto.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> page) {
        return ReviewResponseDto.ReviewPreViewListDTO.builder()
                .reviewList(
                        page.getContent().stream()
                                .map(ReviewConverter::toReviewPreViewDTO)
                                .toList()
                )
                .listSize(page.getSize())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }

    // Review → ReviewPreViewDTO 변환
    public static ReviewResponseDto.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getRating())
                .body(review.getContent())
                // createdAt 필드는 엔티티에 따라 맞게 수정
                .createAt(LocalDate.now())
                .build();
    }
}
