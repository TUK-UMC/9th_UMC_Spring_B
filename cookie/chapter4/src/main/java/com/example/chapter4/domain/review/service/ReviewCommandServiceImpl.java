package com.example.chapter4.domain.review.service;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.member.repository.MemberRepository;
import com.example.chapter4.domain.store.entity.Menu;
import com.example.chapter4.domain.store.repository.MenuRepository;
import com.example.chapter4.domain.review.converter.ReviewConverter;
import com.example.chapter4.domain.review.dto.ReviewReqDTO;
import com.example.chapter4.domain.review.dto.ReviewResDTO;
import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter4.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResDTO addReview(ReviewReqDTO dto) {
        // DB에서 아무 회원 하나 하드코딩 조회 (첫번째 회원)
        Member member = memberRepository.findAll(PageRequest.of(0, 1))
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));

        // 메뉴 조회
        Menu menu = menuRepository.findById(dto.getMenuId())
                .orElseThrow(() -> new NoSuchElementException("메뉴를 찾을 수 없습니다."));

        // 리뷰 엔티티 생성
        Review review = ReviewConverter.toEntity(member.getId(), dto, menu, member);

        // 저장
        Review saved = reviewRepository.save(review);

        // DTO로 변환해 반환
        return ReviewConverter.toDTO(saved);
    }
}
