package com.example.chapter6.domain.review.service.query;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.MemberRepository;
import com.example.chapter6.domain.review.dto.MyReviewDTO;
import com.example.chapter6.domain.review.entity.Review;
import com.example.chapter6.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        // page는 0부터 시작하므로 -1 처리 (프론트는 1부터 보냄)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        return reviewRepository.findAllByMember(member, pageRequest);
    }
}