package com.example.chapter6.domain.review.service.command;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.MemberRepository;
import com.example.chapter6.domain.review.converter.ReviewConverter;
import com.example.chapter6.domain.review.dto.ReviewReqDTO;
import com.example.chapter6.domain.review.dto.ReviewResDTO;
import com.example.chapter6.domain.review.entity.Review;
import com.example.chapter6.domain.review.exception.ReviewException;
import com.example.chapter6.domain.review.exception.code.ReviewErrorCode;
import com.example.chapter6.domain.review.repository.ReviewRepository;
import com.example.chapter6.domain.store.entity.Menu;
import com.example.chapter6.domain.store.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional // Command Service는 @Transactional이 필요합니다.
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;


    @Override
    public ReviewResDTO.CreateReviewDTO createReview(Long memberId, ReviewReqDTO.CreateReviewDTO dto) {

        // 1. 회원 조회 (리뷰 작성자)
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 2. 메뉴 조회 (리뷰 대상)
        Menu menu = menuRepository.findById(dto.menuId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.MENU_NOT_FOUND));

        // 3. Review 엔티티 생성 및 저장
        Review review = ReviewConverter.toReview(dto, member, menu);
        review = reviewRepository.save(review);

        // 4. 응답 DTO 변환 및 반환
        return ReviewConverter.toCreateReviewDTO(review);
    }
}