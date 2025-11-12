package com.example.chapter6.domain.review.repository;

import com.example.chapter6.domain.review.dto.MyReviewDTO;
import java.util.List;

public interface ReviewRepositoryCustom {

    /**
     * 마이 페이지 - 내가 작성한 리뷰 목록 동적 조회 (QueryDSL)
     *
     * @param memberId     필수: 현재 로그인한 회원 ID
     * @param storeName    선택: 필터링할 가게 이름 (null이나 빈 값이면 전체)
     * @param ratingFilter 선택: 필터링할 별점 (5점, 4점대, 3점대...) (null이면 전체)
     */
    List<MyReviewDTO> findMyReviewsDynamic(Long memberId, String storeName, Integer ratingFilter);
}