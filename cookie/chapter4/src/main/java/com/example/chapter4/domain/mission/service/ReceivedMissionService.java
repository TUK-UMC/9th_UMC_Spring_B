package com.example.chapter4.domain.mission.service;

import com.example.chapter4.domain.mission.converter.ReceivedMissionConverter;
import com.example.chapter4.domain.mission.dto.MissionProgressDto;
import com.example.chapter4.domain.mission.entity.ReceivedMission;
import com.example.chapter4.domain.mission.repository.ReceivedMissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class ReceivedMissionService {
    private final ReceivedMissionRepository receivedMissionRepository;

    public ReceivedMissionService(ReceivedMissionRepository receivedMissionRepository) {
        this.receivedMissionRepository = receivedMissionRepository;
    }

    public Page<MissionProgressDto> getMyProgressMissions(Long memberId, Pageable pageable) {
        Page<ReceivedMission> progressPage = receivedMissionRepository
                .findByMemberIdAndStatus(memberId, "IN_PROGRESS", (org.springframework.data.domain.Pageable) pageable);
        return progressPage.map(ReceivedMissionConverter::toDto);
    }
}
