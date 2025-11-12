package com.umc.umc.domain.user.service;

import com.umc.umc.domain.review.entity.Review;
import com.umc.umc.domain.review.repository.ReviewRepository;
import com.umc.umc.domain.store.entity.Region;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.store.repository.RegionRepository;
import com.umc.umc.domain.store.repository.StoreRepository;
import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static com.umc.umc.domain.user.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("리뷰 생성 및 확인")
    void getMyReviews() {
        User user = User.builder()
                .name("tester")
                .email("test@gmail.com")
                .birth(LocalDate.now())
                .phoneNumber("010-0000-0000")
                .gender(MALE)
                .address("경기도 시흥시 정왕동")
                .point(0)
                .build();

        userRepository.save(user);

        Region region = Region.builder()
                .name("경기도")
                .build();
        regionRepository.save(region);

        Store store = Store.builder()
                .name("테스트 가게")
                .address("경기도 시흥시 정왕동")
                .description("테스트 가게입니다.")
                .region(region)
                .build();
        storeRepository.save(store);

        Review review1 = Review.createReview(user, store, "첫 주문입니다!", 4.5, "맛있게먹었습니다!");
        Review review2 = Review.createReview(user, store, "두번째 주문입니다!", 3.5, "별로였습니다!");

        reviewRepository.saveAll(List.of(review1, review2));

        MyReviewSearchCond cond = new  MyReviewSearchCond();
        Pageable pageable = PageRequest.of(0, 10);
        Page<MyReviewDto> result = userServiceImpl.getMyReviews(user.getId(), cond, pageable);

        Assertions.assertEquals(2, result.getTotalElements());

    }






}