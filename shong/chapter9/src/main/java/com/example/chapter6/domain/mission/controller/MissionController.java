package com.example.chapter6.domain.mission.controller;

import com.example.chapter6.domain.mission.converter.MissionConverter;
import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import com.example.chapter6.domain.mission.exception.code.MissionSuccessCode;
import com.example.chapter6.domain.mission.service.command.MissionCommandService;
import com.example.chapter6.domain.mission.service.query.MissionQueryService;
import com.example.chapter6.global.annotation.CheckPage;
import com.example.chapter6.global.apiPayload.ApiResponse;
import com.example.chapter6.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
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

    // --- 특정 가게의 미션 목록 조회 API ---
    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 조회합니다. 페이징(10개 단위)을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "page 번호가 1보다 작습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON404", description = "가게를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작), 1 미만 입력 시 에러 발생")
    })
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissionList(
            @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        // 1. Service 호출 (Page 객체 받기)
        Page<Mission> missionPage = missionQueryService.getMissionList(storeId, page);

        // 2. Converter 호출 (DTO 변환 - Stream 사용됨)
        MissionResDTO.MissionPreViewListDTO resultDTO = MissionConverter.toMissionPreViewListDTO(missionPage);

        // 3. 응답 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDTO);
    }

    // --- 내가 진행중인 미션 목록 조회 ---
    @GetMapping("/me")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "나의 미션 목록을 조회합니다. status 파라미터로 '진행중' 또는 '완료'를 구분할 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "page 번호가 1보다 작습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "status", description = "미션 상태 (진행중 / 완료)"),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)")
    })
    public ApiResponse<MissionResDTO.MyMissionPreViewListDTO> getMyMissions(
            @RequestParam(name = "status") String status,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        Long memberId = 1L; // (임시 ID)

        // 1. Service 호출
        Page<ReceivedMission> missionPage = missionQueryService.getMyMissions(memberId, status, page);

        // 2. Converter 호출
        MissionResDTO.MyMissionPreViewListDTO resultDTO = MissionConverter.toMyMissionPreViewListDTO(missionPage);

        // 3. 응답 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDTO);
    }

    /**
     * PATCH /missions/{receivedMissionId}/complete
     * 진행 중인 미션 완료로 변경 API
     */
    @PatchMapping("/{receivedMissionId}/complete")
    @Operation(summary = "진행중인 미션 완료 변경 API", description = "진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION404", description = "미션을 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "receivedMissionId", description = "나의 미션 아이디 (ReceivedMission ID) Path Variable")
    })
    public ApiResponse<MissionResDTO.MissionCompleteDTO> completeMission(
            @PathVariable(name = "receivedMissionId") Long receivedMissionId
    ) {
        Long memberId = 1L; // (임시 ID)

        // 1. Service 호출 (상태 변경 및 DTO 반환)
        MissionResDTO.MissionCompleteDTO resultDTO = missionCommandService.completeMission(memberId, receivedMissionId);

        // 2. 응답 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, resultDTO);
    }

}