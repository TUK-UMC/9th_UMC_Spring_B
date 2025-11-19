package com.example.chapter6.domain.mission.service.command;

import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.MemberRepository;
import com.example.chapter6.domain.mission.converter.MissionConverter;
import com.example.chapter6.domain.mission.dto.MissionResDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import com.example.chapter6.domain.mission.exception.MissionException;
import com.example.chapter6.domain.mission.exception.code.MissionErrorCode;
import com.example.chapter6.domain.mission.repository.MissionRepository;
import com.example.chapter6.domain.mission.repository.ReceivedMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional // 커맨드 서비스는 쓰기 작업이 있으므로 @Transactional을 적용합니다.
public class MissionCommandServiceImpl implements MissionCommandService {

    // 필요한 Repository 주입
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final ReceivedMissionRepository receivedMissionRepository;

    @Override
    public MissionResDTO.AcceptMissionDTO acceptMission(Long memberId, Long missionId) {

        // 1. 회원(Member) 존재 확인 (MemberException 활용)
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 2. 미션(Mission) 존재 확인 (MissionException 활용)
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        // 3. 미션 중복 수락 확인 (추가적인 Repository 쿼리 필요)
        receivedMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .ifPresent(receivedMission -> {
                    // 이미 존재한다면 중복 수락 예외 발생
                    throw new MissionException(MissionErrorCode.MISSION_ALREADY_ACCEPTED);
                });

        // 4. ReceivedMission 엔티티 생성
        ReceivedMission newReceivedMission = MissionConverter.toReceivedMission(member, mission);

        // 5. DB 저장
        ReceivedMission savedMission = receivedMissionRepository.save(newReceivedMission);

        // 6. 응답 DTO 반환
        return MissionConverter.toAcceptMissionDTO(savedMission);
    }
}
