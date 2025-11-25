package com.umc.umc.domain.mission.controller;

import com.umc.umc.domain.mission.converter.MissionConverter;
import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.dto.res.MissionResponseDto;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.exception.code.MissionSuccessCode;
import com.umc.umc.domain.mission.service.MissionService;
import com.umc.umc.global.apiPayload.ApiResponse;
import com.umc.umc.global.validation.annotation.CheckPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
    private final MissionConverter missionConverter;

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

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 조회합니다. Query String으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 ID"),
            @Parameter(name = "page", description = "페이지 번호 (1 이상)", example = "1")
    })
    public ApiResponse<MissionResponseDto.MissionListDto> getMissions(
            @PathVariable Long storeId,
            @CheckPage @RequestParam(name = "page")Integer page
    ) {
        Page<Mission> missionList = missionService.getMissionList(storeId, page);

            return ApiResponse.success(MissionSuccessCode.FOUND, missionConverter.toMissionListDto(missionList));
    }




}
