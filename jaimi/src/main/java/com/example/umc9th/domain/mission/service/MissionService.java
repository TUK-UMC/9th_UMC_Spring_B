package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionHomeResponseDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionHomeResponseDto> getMissionsByRegion(String region, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Mission> missions = missionRepository.findMissionsByRegion(region, pageRequest);

        return missions.stream()
                .map(m -> new MissionHomeResponseDto(
                        m.getStore().getName(),
                        m.getStore().getAddress(),
                        m.getMissionExplain(),
                        m.getMissionAward()
                ))
                .collect(Collectors.toList());
    }
}
