package com.example.chapter6.domain.mission.controller;

import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import com.example.chapter6.domain.mission.exception.code.MissionSuccessCode;
import com.example.chapter6.domain.mission.service.command.MissionCommandService;
import com.example.chapter6.domain.mission.service.query.MissionQueryService;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    // QueryService 주입
    private final MissionQueryService missionQueryService;
    private final MissionCommandService missionCommandService;

    /**
     * POST /missions/{missionId}/accept
     * 미션 수락 API
     */
    @PostMapping("/{missionId}/accept")
    public ApiResponse<MissionResDTO.AcceptMissionDTO> acceptMission(
            @PathVariable(name = "missionId") Long missionId
    ) {
        Long memberId = 1L; // (임시 ID) - 실제로는 인증 정보에서 가져와야 합니다.

        // 1. Service 호출
        MissionResDTO.AcceptMissionDTO resultDto = missionCommandService.acceptMission(memberId, missionId);

        // 2. [응답 통일 - 성공]
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_ACCEPT_SUCCESS, resultDto);
    }

    @GetMapping("/me")
    public ApiResponse<Page<MyMissionDTO>> getMyMissions(
            @RequestParam(name = "status") String status,

            // Pageable에 기본 정렬(updatedAt 기준 내림차순)을 지정합니다.
            // 클라이언트가 ?page=1&sort=createdAt,asc 처럼 다른 정렬을 요청하면
            // 이 기본값은 무시되고 클라이언트 요청이 우선 적용됩니다
            @PageableDefault(page = 0, size = 10, sort = "updatedAt", direction = Sort.Direction.DESC)
            Pageable pageable
    ) {

        Long memberId = 1L; // (임시 ID)

        // 1. Service 호출
        Page<MyMissionDTO> resultPage = missionQueryService.getMyMissions(memberId, status, pageable);

        // 2. [응답 통일 - 성공]
        //    Page 객체 자체를 반환하면 페이징 정보가 포함된 DTO가 됩니다.
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultPage);
    }
}