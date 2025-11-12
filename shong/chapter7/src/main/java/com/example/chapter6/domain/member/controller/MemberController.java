package com.example.chapter6.domain.member.controller;

import com.example.chapter6.domain.member.dto.MyPageInfoDTO;
import com.example.chapter6.domain.member.service.query.MemberQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    // QueryService를 주입받는다.
    private final MemberQueryService memberQueryService;

    @GetMapping("/me")
    public ApiResponse<MyPageInfoDTO> getMyPage() {

        Long memberId = 1L; // (임시 ID)

        // 1. Service를 호출합니다.
        //    (성공 시 MyPageInfoDTO 반환, 실패 시 Service에서 MemberException 발생)
        MyPageInfoDTO resultDto = memberQueryService.getMyPageInfo(memberId);

        // 2. [응답 통일 - 성공]
        //    ApiResponse.onSuccess()로 감싸 반환합니다.
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDto);
    }
}