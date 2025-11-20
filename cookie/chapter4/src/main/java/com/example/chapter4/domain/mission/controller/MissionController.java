package com.example.chapter4.domain.mission.controller;

import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;
import com.example.chapter4.domain.mission.service.command.MissionCommandService;
import com.example.chapter4.global.apiPayload.ApiResponse;
import com.example.chapter4.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    /**
     * 미션 도전하기 요청 처리
     * @param dto 미션 도전 요청 DTO
     * @return 미션 도전 결과 DTO
     */
    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResDTO> challengeMission(@RequestBody MissionChallengeReqDTO dto) {
        MissionChallengeResDTO resDTO = missionCommandService.challengeMission(dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resDTO);
    }
}
