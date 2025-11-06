package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.MyPageResponseDto;
import com.example.umc9th.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 마이페이지 조회
    @GetMapping("/{userId}/mypage")
    public MyPageResponseDto getMyPage(@PathVariable Long userId) {
        return userService.getMyPage(userId);
    }
}
