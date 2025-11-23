package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionPreviewListDTO;
import com.example.umc9th.domain.mission.service.MissionQueryService;
import com.example.umc9th.global.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionQueryService MissionQueryService;

    // 1. 특정 가게의 미션 목록 조회
    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회")
    public MissionPreviewListDTO getMissionByStore(
            @PathVariable Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        return MissionQueryService.getMissionByStore(storeId, page);
    }

    // 2. 내가 진행중인 미션 목록 조회
    @GetMapping("/me")
    @Operation(summary = "내가 진행중인 미션 목록 조회")
    public MissionPreviewListDTO getMyOngoingMission(
            @ValidPage @RequestParam Integer page
    ) {
        Long userId = 1L; // JWT 사용 시 SecurityContext 에서 가져오면 됨
        return MissionQueryService.getMyOngoingMissions(userId, page);
    }
}
