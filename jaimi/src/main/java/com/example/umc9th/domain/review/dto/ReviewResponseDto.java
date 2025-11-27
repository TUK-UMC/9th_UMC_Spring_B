package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;


// 리뷰 응답 데이터 전송 객체 (DTO)
// Controller → 클라이언트로 데이터를 전달할 때 사용
@Getter
@AllArgsConstructor
public class ReviewResponseDto {

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList, // 리뷰 정보를 담은 DTO를 list로 담은 또 다른 dto
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ){}
}

