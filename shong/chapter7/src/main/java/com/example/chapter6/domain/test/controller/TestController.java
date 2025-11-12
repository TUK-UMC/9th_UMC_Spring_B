package com.example.chapter6.domain.test.controller;

import com.example.chapter6.domain.test.converter.TestConverter;
import com.example.chapter6.domain.test.dto.res.TestResDTO;
import com.example.chapter6.domain.test.service.query.TestQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() throws Exception {
        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        //code 변수는 { HttpStatus.OK, "COMMON200_1", "요청에 성공했습니다." }가 담긴다
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("This is Test!")
        );
        //      TestConverter의 'toTestingDTO' 메서드를 호출하여
        //      "This is Test!"라는 문자열을 'TestResDTO.Testing' 객체로 변환하여
        //      result 객체를 전달합니다.
    }

    // 예외 상황
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.Exception> exception(
            @RequestParam Long flag
    ) {
        testQueryService.checkFlag(flag);

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDTO("This is Test!"));
    }
}
