package com.example.chapter4.domain.mission.service.command;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.member.repository.MemberRepository;
import com.example.chapter4.domain.mission.converter.MissionConverter;
import com.example.chapter4.domain.mission.dto.MissionChallengeReqDTO;
import com.example.chapter4.domain.mission.dto.MissionChallengeResDTO;
import com.example.chapter4.domain.mission.entity.Mission;
import com.example.chapter4.domain.mission.entity.ReceivedMission;
import com.example.chapter4.domain.mission.repository.MissionRepository;
import com.example.chapter4.domain.mission.repository.ReceivedMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final ReceivedMissionRepository receivedMissionRepository;

    /**
     * 회원이 미션에 도전하는 기능 구현
     * 로그인 기능이 없으므로 DB 내 첫 번째 회원을 하드코딩 사용
     * @param dto 미션 도전 요청 DTO
     * @return 미션 도전 결과 DTO
     */
    @Override
    @Transactional
    public MissionChallengeResDTO challengeMission(MissionChallengeReqDTO dto) {
        // DB의 아무 회원 1명 조회 (하드코딩)
        Member member = memberRepository.findAll(PageRequest.of(0, 1))
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));

        // 요청된 미션 조회
        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new NoSuchElementException("미션을 찾을 수 없습니다."));

        // 새 ReceivedMission 엔티티 생성 (초기 상태 설정 포함)
        ReceivedMission receivedMission = MissionConverter.toReceivedMission(dto, mission, member);

        // 도전 미션 저장
        ReceivedMission saved = receivedMissionRepository.save(receivedMission);

        // 저장된 도전 미션을 DTO로 변환하여 반환
        return MissionConverter.toChallengeResDTO(saved);
    }

    public Page<Mission> getMissionsByStore(Long storeId, Pageable pageable) {
        return null;
    }
}
