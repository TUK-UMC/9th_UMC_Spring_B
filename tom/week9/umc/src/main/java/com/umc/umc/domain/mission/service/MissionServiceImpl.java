package com.umc.umc.domain.mission.service;

import com.umc.umc.domain.mission.converter.MissionConverter;
import com.umc.umc.domain.mission.dto.req.MissionCreateReq;
import com.umc.umc.domain.mission.dto.res.MissionChallengeRes;
import com.umc.umc.domain.mission.dto.res.MissionCreateRes;
import com.umc.umc.domain.mission.dto.res.MissionResponseDto;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.entity.MissionStatus;
import com.umc.umc.domain.mission.exception.MissionException;
import com.umc.umc.domain.mission.exception.code.MissionErrorCode;
import com.umc.umc.domain.mission.repository.MissionRepository;
import com.umc.umc.domain.mission.repository.MissionStatusRepository;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.store.exception.StoreException;
import com.umc.umc.domain.store.exception.code.StoreErrorCode;
import com.umc.umc.domain.store.repository.StoreRepository;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.exception.UserException;
import com.umc.umc.domain.user.exception.code.UserErrorCode;
import com.umc.umc.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final MissionStatusRepository missionStatusRepository;
    private final MissionConverter missionConverter;

    @Override
    public MissionCreateRes createMission(MissionCreateReq request, Long storeId) {
        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        Mission missionEntity = missionConverter.toMission(request, findStore);
        missionRepository.save(missionEntity);

        return missionConverter.toMissionCreateRes(missionEntity);
    }

    @Override
    public MissionChallengeRes challengeMission(Long userId, Long missionId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        Mission findMission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        // 이미 도전한 미션인지 확인
        missionStatusRepository.findByUserAndMission(findUser, findMission)
                .ifPresent(missionStatus -> {
                    new MissionException(MissionErrorCode.MISSION_ALREADY_CHALLENGED);
                });

        MissionStatus newMissionStatus = missionConverter.toMissionStatus(findUser, findMission);

        MissionStatus savedMissionStatus = missionStatusRepository.save(newMissionStatus);

        return missionConverter.toMissionChallengeResponse(savedMissionStatus);
    }

    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        return missionRepository.findAllByStore(store, pageRequest);
    }

    @Override
    public MissionResponseDto.OnGoingListDto getMyOngoingMission(Long userId, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        Page<MissionResponseDto.OngoingMissionDto> missionDtoPage
                = missionStatusRepository.findOngoingMissionsByUserId(user.getId(), "ONGOING", pageRequest);

        return missionConverter.toOnGoingListDto(missionDtoPage);

    }


}
