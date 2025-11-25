package com.umc.umc.domain.mission.controller;

import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.exception.code.MissionSuccessCode;
import com.umc.umc.domain.mission.service.MissionService;
import com.umc.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionCreateRes> createMission(@PathVariable Long storeId, MissionCreateReq request) {
        MissionCreateRes missionCreateRes = missionService.createMission(request, storeId);

        return ApiResponse.success(MissionSuccessCode.CREATED, missionCreateRes);
    }

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionChallengeRes> challengeMission(
            @PathVariable Long missionId,
            @RequestHeader Long userId
    ) {
        MissionChallengeRes missionChallengeRes = missionService.challengeMission(missionId, userId);
        return ApiResponse.success(MissionSuccessCode.FOUND, missionChallengeRes);
    }
}
