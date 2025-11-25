package com.umc.umc.domain.user.controller;


import com.umc.umc.domain.user.dto.MyReviewDto;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.exception.code.UserSuccessCode;
import com.umc.umc.domain.user.service.UserServiceImpl;
import com.umc.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.umc.umc.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/users/me/reviews")
    public ApiResponse<Page<MyReviewDto>> getMyReviews(
            @ModelAttribute MyReviewSearchCond cond,
            @PageableDefault(size = 10) Pageable pageable
    ) {

        Long userId = 1L; // 테스트를 위해서 userId를 하드코딩

        Page<MyReviewDto> myReviews = userService.getMyReviews(userId, cond, pageable);
        return ApiResponse.success(OK, myReviews);
    }

    @PostMapping("/sign-up")
    public ApiResponse<UserResDto> signUp(
        @RequestBody UserReqDto dto
            ) {
        return ApiResponse.success(UserSuccessCode.CREATED, userService.signup(dto));
    }

}
