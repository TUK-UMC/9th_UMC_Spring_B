package com.example.chapter4.domain.mission.controller;

import com.example.chapter4.annotation.ValidPage;
import com.example.chapter4.domain.mission.converter.MissionConverter;
import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;
import com.example.chapter4.domain.mission.dto.MissionProgressDto;
import com.example.chapter4.domain.mission.entity.Mission;
import com.example.chapter4.domain.mission.service.command.MissionCommandService;
import com.example.chapter4.domain.mission.service.ReceivedMissionService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import com.example.chapter4.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final ReceivedMissionService receivedMissionService;

    /**
     * 미션 도전하기 요청 처리
     */
    @Operation(summary="미션 도전하기", description="미션 챌린지 요청")
    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResDTO> challengeMission(@RequestBody MissionChallengeReqDTO dto) {
        MissionChallengeResDTO resDTO = missionCommandService.challengeMission(dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resDTO);
    }

    /**
     * 특정 가게의 미션 목록 페이징 조회 (조건: page 1-base)/건별 10개
     */
    @Operation(summary="특정 가게의 미션 목록 조회", description="page는 1-base, 한 페이지에 10개. page<1은 에러")
    @GetMapping("/store")
    public ApiResponse<Page<MissionChallengeResDTO>> getMissionsByStore(
            @RequestParam Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<Mission> pageMissions = missionCommandService.getMissionsByStore(storeId, pageable);
        Page<MissionChallengeResDTO> dtoPage = pageMissions.map(MissionConverter::toChallengeResDTO);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, dtoPage);
    }

    /**
     * 내가 진행중인 미션 목록 페이징 조회 (진행중 상태만, 건별 10개)
     */
    @Operation(summary = "진행중인 미션 목록 페이징 조회", description = "진행중 상태(IN_PROGRESS)만, 한 페이지 10개, page는 1부터, 0/음수/비정상은 에러")
    @GetMapping("/mine")
    public ApiResponse<Page<MissionProgressDto>> getMyProgressMissions(
            @RequestParam Long memberId,
            @ValidPage @RequestParam Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<MissionProgressDto> dtoPage = receivedMissionService.getMyProgressMissions(memberId, (java.awt.print.Pageable) pageable);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, dtoPage);
    }
}
