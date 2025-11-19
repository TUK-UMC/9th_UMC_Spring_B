package com.example.umc9th.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.umc9th.domain.mission.service.MissionService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/{missionId}/challenge")
    public String challengeMission(@PathVariable Long missionId) {
        missionService.challengeMission(missionId);
        return "미션 도전 완료";
    }
}

