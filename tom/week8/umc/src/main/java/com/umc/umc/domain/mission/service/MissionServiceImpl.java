package com.umc.umc.domain.mission.service;

import com.umc.umc.domain.mission.converter.MissionConverter;
import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.repository.MissionRepository;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.store.exception.StoreException;
import com.umc.umc.domain.store.exception.code.StoreErrorCode;
import com.umc.umc.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MissionConverter missionConverter;

    @Override
    public MissionCreateRes createMission(MissionCreateReq request, Long storeId) {
        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        Mission missionEntity = missionConverter.toEntity(request, findStore);
        missionRepository.save(missionEntity);

        return missionConverter.toMissionCreateRes(missionEntity);

    }
}
