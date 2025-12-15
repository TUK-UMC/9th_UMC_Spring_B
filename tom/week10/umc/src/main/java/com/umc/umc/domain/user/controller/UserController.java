package com.umc.umc.domain.user.controller;


import com.umc.umc.domain.review.dto.MyReviewDto;
import com.umc.umc.domain.review.exception.code.ReviewSuccessCode;
import com.umc.umc.domain.user.dto.MyReviewSearchCond;
import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.exception.code.UserSuccessCode;
import com.umc.umc.domain.user.service.UserServiceImpl;
import com.umc.umc.global.apiPayload.ApiResponse;
import com.umc.umc.global.apiPayload.code.GeneralSuccessCode;
import com.umc.umc.global.validation.annotation.CheckPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.umc.umc.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/me/reviews")
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

    //로그인
    @PostMapping("/login")
    @Operation(summary = "로그인 API", description = "회원인지 확인하고 로그인합니다.")
    public ApiResponse<UserResDto.LoginDto> login (
        @RequestBody @Valid UserReqDto.LoginDto dto
    ) {
        return ApiResponse.success(UserSuccessCode.FOUND, userService.login(dto));
    }

    @GetMapping("/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "마이페이지에서 내가 쓴 리뷰를 조회합니다.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 (1 이상)", example = "1")
    })
    public ApiResponse<MyReviewDto.ReviewListDto> getMyReviews(
            @RequestHeader Long userId,
            @CheckPage
            @RequestParam(name = "page") Integer page
    ) {

        MyReviewDto.ReviewListDto result = userService.getMyReviews(userId, page);

        return ApiResponse.success(ReviewSuccessCode.FOUND, result);
    }

}
