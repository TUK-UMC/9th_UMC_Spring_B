package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionHomeResponseDto;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class MissionController {

    private final MissionService missionService;

    // 홈화면 지역별 미션 조회
    @GetMapping("/missions")
    public ApiResponse<List<MissionHomeResponseDto>> getMissionsByRegion(
            @RequestParam String region,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<MissionHomeResponseDto> missions = missionService.getMissionsByRegion(region, page, size);

        // ApiResponse로 감싸서 반환
        return ApiResponse.<List<MissionHomeResponseDto>>onSuccess(GeneralSuccessCode.MISSION_REGION_LIST_SUCCESS,
                missions
        );

    }
}
