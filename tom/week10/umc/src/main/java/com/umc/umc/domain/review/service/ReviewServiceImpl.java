package com.umc.umc.domain.review.service;

import com.umc.umc.domain.review.converter.ReviewConverter;
import com.umc.umc.domain.review.dto.req.ReviewReqDTO;
import com.umc.umc.domain.review.dto.res.ReviewResDTO;
import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.store.exception.StoreException;
import com.umc.umc.domain.store.repository.StoreRepository;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.exception.UserException;
import com.umc.umc.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.umc.umc.domain.user.exception.code.UserErrorCode.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewConverter reviewConverter;

    @Override
    public ReviewResDTO.ReviewCreateResponse createReview(ReviewReqDTO.ReviewCreateRequest request, Long UserId, Long storeId) {
        User findUser = userRepository.findById(UserId)
                .orElseThrow(() -> new UserException(NOT_FOUND));
        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(NOT_FOUND));

        Review reviewEntity = reviewConverter.toEntity(request, findUser, findStore);
        reviewRepository.save(reviewEntity);

        return reviewConverter.toReviewCreateResponse(reviewEntity);
    }
}
