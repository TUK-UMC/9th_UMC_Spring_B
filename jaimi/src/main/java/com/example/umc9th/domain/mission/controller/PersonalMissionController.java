package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.PersonalMissionResponseDto;
import com.example.umc9th.domain.mission.service.PersonalMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class PersonalMissionController {

    private final PersonalMissionService personalMissionService;

    // 미션 상태별 조회 (진행중 / 완료)
    @GetMapping("/user/{userId}")
    public List<PersonalMissionResponseDto> getMissions(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "진행중") String progress,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return personalMissionService.getMissions(userId, progress, page, size);
    }
}
