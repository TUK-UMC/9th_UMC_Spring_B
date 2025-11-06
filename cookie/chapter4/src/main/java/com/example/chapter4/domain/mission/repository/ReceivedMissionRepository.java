package com.example.chapter4.domain.mission.repository;

import com.example.chapter4.domain.mission.entity.ReceivedMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReceivedMissionRepository extends JpaRepository<ReceivedMission, Long> {

    // 회원별 진행중/완료 미션 모두 조회 (페이징)
    @Query("SELECT rm FROM ReceivedMission rm " +
            "WHERE rm.member.id = :memberId " +
            "AND (rm.status = '진행중' OR rm.status = '완료') " +
            "ORDER BY rm.deadline DESC")
    Page<ReceivedMission> findActiveOrCompletedMissions(@Param("memberId") Long memberId, Pageable pageable);

}
