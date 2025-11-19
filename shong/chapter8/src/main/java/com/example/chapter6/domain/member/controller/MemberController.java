package com.example.chapter6.domain.member.controller;

import com.example.chapter6.domain.member.dto.MemberReqDTO;
import com.example.chapter6.domain.member.dto.MemberResDTO;
import com.example.chapter6.domain.member.dto.MyPageInfoDTO;
import com.example.chapter6.domain.member.exception.code.MemberSuccessCode;
import com.example.chapter6.domain.member.service.command.MemberCommandService;
import com.example.chapter6.domain.member.service.query.MemberQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    //회원가입
    @PostMapping("/sign_up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody @Valid MemberReqDTO.JoinDTO dto
            ){
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_FOUND,memberCommandService.signup(dto));
    }

    // QueryService를 주입받는다.
    private final MemberQueryService memberQueryService;

    @GetMapping("/my_page")
    public ApiResponse<MyPageInfoDTO> getMyPage() {

        Long memberId = 1L; // (임시 ID)

        // 1. Service를 호출합니다.
        //    (성공 시 MyPageInfoDTO 반환, 실패 시 Service에서 MemberException 발생)
        MyPageInfoDTO resultDto = memberQueryService.getMyPageInfo(memberId);

        // 2. [응답 통일 - 성공]
        //    ApiResponse.onSuccess()로 감싸 반환합니다.
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_FOUND, resultDto);
    }
}