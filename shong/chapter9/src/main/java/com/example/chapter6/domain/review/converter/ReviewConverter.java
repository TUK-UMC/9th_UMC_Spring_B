package com.example.chapter6.domain.review.converter;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;
import com.example.chapter6.domain.review.entity.Review;
import com.example.chapter6.domain.store.entity.Menu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    // --- 목록 조회 변환 로직 ---

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .storeName(review.getMenu().getStore().getName())
                .menuName(review.getMenu().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewPage) {
        List<ReviewResDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewPage.getContent().stream()
                .map(ReviewConverter::toReviewPreViewDTO) // Stream 사용
                .collect(Collectors.toList());

        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


}
