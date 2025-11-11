package com.example.chapter6.domain.mission.service.query;

import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import com.example.chapter6.domain.mission.repository.ReceivedMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    // '내 미션' 조회를 위해 ReceivedMissionRepository 주입
    private final ReceivedMissionRepository receivedMissionRepository;

    @Override
    public Page<MyMissionDTO> getMyMissions(Long memberId, String status, Pageable pageable) {

        // Repository의 JPQL 쿼리를 호출합니다.
        // 페이징 조회는 결과가 없으면 content가 비어있는 Page 객체를 반환하므로
        // 별도 예외 처리가 필요 없다.
        return receivedMissionRepository.findMyMissions(memberId, status, pageable);
    }
}