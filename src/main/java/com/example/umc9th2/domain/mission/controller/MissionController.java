package com.example.domain.mission.controller;

import com.example.domain.mission.dto.MissionHomeResponseDto;
import com.example.domain.mission.service.MissionService;
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
    public List<MissionHomeResponseDto> getMissionsByRegion(
            @RequestParam String region,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return missionService.getMissionsByRegion(region, page, size);
    }
}
