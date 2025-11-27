package com.example.chapter6.domain.mission.service.query;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.MemberRepository;
import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import com.example.chapter6.domain.mission.repository.MissionRepository;
import com.example.chapter6.domain.mission.repository.ReceivedMissionRepository;
import com.example.chapter6.domain.store.entity.Store;
import com.example.chapter6.domain.store.repository.StoreRepository;
import com.example.chapter6.global.apiPayload.code.GeneralErrorCode;
import com.example.chapter6.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    // '내 미션' 조회를 위해 ReceivedMissionRepository 주입
    private final ReceivedMissionRepository receivedMissionRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    // 내 미션 목록 조회
    @Override
    public Page<ReceivedMission> getMyMissions(Long memberId, String status, Integer page) {

        // 1. 회원 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 2. 페이징 설정 (0부터 시작)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 3. Repository 호출
        return receivedMissionRepository.findAllByMemberAndStatus(member, status, pageRequest);
    }

    // 특정 가게의 미션 목록 조회 구현
    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        // 1. 가게 존재 여부 확인 (없으면 404 에러)
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));
        // 혹은 StoreErrorCode.STORE_NOT_FOUND가 있다면 그것을 사용

        // 2. 페이징 처리 (0부터 시작하므로 -1)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        return missionRepository.findAllByStore(store, pageRequest);
    }

}