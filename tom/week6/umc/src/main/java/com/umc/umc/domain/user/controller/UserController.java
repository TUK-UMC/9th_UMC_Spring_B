package com.umc.umc.domain.user.controller;


import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users/me/reviews")
    public ResponseEntity<Page<MyReviewDto>> getMyReviews(
            @ModelAttribute MyReviewSearchCond cond,
            @PageableDefault(size = 10) Pageable pageable
            ) {

        Long userId = 1L; // 테스트를 위해서 userId를 하드코딩

        Page<MyReviewDto> myReviews = userService.getMyReviews(userId, cond, pageable);

        return ResponseEntity.ok(myReviews);
    }
}
