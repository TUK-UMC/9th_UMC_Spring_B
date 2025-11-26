package com.example.chapter4.domain.mission.service;

import com.example.chapter4.domain.mission.entity.Mission;
import com.example.chapter4.domain.mission.repository.MissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MissionService {
    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Page<Mission> getMissionsByStore(Long storeId, Pageable pageable) {
        return missionRepository.findByStoreId(storeId, pageable);
    }
}
