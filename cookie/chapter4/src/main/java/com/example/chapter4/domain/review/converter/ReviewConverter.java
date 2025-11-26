package com.example.chapter4.domain.review.converter;

import com.example.chapter4.domain.review.dto.ReviewReqDTO;
import com.example.chapter4.domain.review.dto.ReviewResDTO;
import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.store.entity.Menu; // 수정된 부분: store.entity 메뉴 임포트
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {

    public static Review toEntity(Long memberId, ReviewReqDTO dto, Menu menu, Member member) {
        return Review.builder()
                .member(member)
                .menu(menu)
                .rating(dto.getRating())
                .content(dto.getContent())
                .build();
    }

    public static ReviewResDTO toDTO(Review review) {
        return ReviewResDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .menuId(review.getMenu().getId())
                .rating(review.getRating())
                .content(review.getContent())
                .build();
    }
    // result -> DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getRating())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }

}
