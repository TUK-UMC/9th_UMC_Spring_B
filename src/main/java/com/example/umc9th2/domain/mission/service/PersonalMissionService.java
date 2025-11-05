package com.example.domain.mission.service;

import com.example.domain.mission.dto.PersonalMissionResponseDto;
import com.example.domain.mission.entity.PersonalMission;
import com.example.domain.mission.repository.PersonalMissionRepository;
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
public class PersonalMissionService {

    private final PersonalMissionRepository personalMissionRepository;

    public List<PersonalMissionResponseDto> getMissions(Long userId, String progress, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<PersonalMission> missions = personalMissionRepository.findByUserIdAndProgress(userId, progress, pageRequest);

        return missions.stream()
                .map(pm -> new PersonalMissionResponseDto(
                        pm.getMission().getStore().getName(),
                        pm.getMission().getMissionExplain(),
                        pm.getMission().getMissionAward(),
                        pm.getProgress()
                ))
                .collect(Collectors.toList());
    }
}
