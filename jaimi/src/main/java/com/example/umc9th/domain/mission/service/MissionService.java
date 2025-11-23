package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.entity.PersonalMission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.PersonalMissionRepository;
import com.example.umc9th.domain.user.entity.user;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final PersonalMissionRepository personalMissionRepository;

    public void challengeMission(Long missionId) {

        user user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션 없음"));

        PersonalMission pm = PersonalMission.builder()
                .user(user)
                .mission(mission)
                .time(0)
                .build();

        personalMissionRepository.save(pm);
    }

}
