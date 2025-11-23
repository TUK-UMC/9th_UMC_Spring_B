package com.example.umc9th.domain.mission.service;

import lombok.RequiredArgsConstructor;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionPreviewListDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.MissionStatus;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.user;
import com.example.umc9th.domain.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryService {
    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    // 1. 특정 가게의 미션 목록
    public MissionPreviewListDTO getMissionByStore(Long storeId, int page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Pageable pageable = PageRequest.of(page - 1, 10);

        Page<Mission> missions = missionRepository.findAllByStore(store, pageable);

        return missionConverter.toPreviewList(missions.getContent());
    }
    // 2. 내가 진행중인 미션 목록
    public MissionPreviewListDTO getMyOngoingMissions(Long userId, int page) {

        user user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Pageable pageable = PageRequest.of(page - 1, 10);

        Page<Mission> missions = missionRepository.findAllByUserAndStatus(
                user, MissionStatus.IN_PROGRESS, pageable
        );

        return missionConverter.toPreviewList(missions.getContent());
    }
}
