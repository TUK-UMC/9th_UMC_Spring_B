package com.umc.umc.domain.review.converter;

import com.umc.umc.domain.review.dto.req.ReviewReqDTO;
import com.umc.umc.domain.review.dto.res.ReviewResDTO;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.review.dto.MyReviewDto;
import com.umc.umc.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewConverter {

    public Review toEntity (ReviewReqDTO.ReviewCreateRequest request, User user, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .rate(request.getRate())
                .user(user)
                .store(store)
                .build();
    }

    public ReviewResDTO.ReviewCreateResponse toReviewCreateResponse(Review review) {
        return new ReviewResDTO.ReviewCreateResponse(
                review.getId(),
                review.getUser().getId(),
                review.getStore().getId(),
                review.getTitle(),
                review.getContent(),
                review.getRate(),
                review.getCreateTime()
        );
    }

    private MyReviewDto.ReviewDto toReviewDto(Review review){
        return MyReviewDto.ReviewDto.builder()
                .storeName(review.getStore().getName())
                .title(review.getTitle())
                .rate(review.getRate())
                .content(review.getContent())
                .createdAt(review.getCreateTime())
                .build();
    }

    public MyReviewDto.ReviewListDto toReviewListDto(
            Page<Review> reviewPage
    ) {
        List<MyReviewDto.ReviewDto> reviewDtoList = reviewPage.stream()
                .map(this::toReviewDto)
                .collect(Collectors.toList());

        return MyReviewDto.ReviewListDto.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewDtoList.size())
                .reviewList(reviewDtoList)
                .build();
    }
}
