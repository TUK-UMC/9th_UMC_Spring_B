package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.MyPageResponseDto;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 마이페이지 조회
    @GetMapping("/{userId}/mypage")
    public ApiResponse<MyPageResponseDto> getMyPage(@PathVariable Long userId) {

        MyPageResponseDto myPage = userService.getMyPage(userId);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.SUCCESS,
                myPage);
    }
}


