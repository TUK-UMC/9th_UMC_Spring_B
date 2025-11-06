package com.example.chapter6.domain.mission.repository;

import com.example.chapter6.domain.mission.dto.MyMissionDTO;
import com.example.chapter6.domain.mission.entity.ReceivedMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReceivedMissionRepository extends JpaRepository<ReceivedMission, Long> {

    /**
     * 홈 화면 - 상단 미션 달성 현황 (완료한 미션 % 10)
     * (SQL: SELECT COUNT(id) % 10 ... FROM Received_mission ...)
     */
    @Query("SELECT COUNT(rm) % 10 " +
            "FROM ReceivedMission rm " +
            "WHERE rm.member.id = :memberId AND rm.status = 'completed'") //
    Long findMissionProgress(@Param("memberId") Long memberId);

    /**
     * 내가 진행중/완료한 미션 목록 조회 (페이징 포함)
     * (SQL: SELECT m.reward, s.name, ... FROM Received_mission rm JOIN ...)
     */
    @Query("SELECT new com.example.chapter6.domain.mission.dto.MyMissionDTO(m.reward, s.name, m.description, rm.status, rm.updatedAt) " +
            "FROM ReceivedMission rm " +    //
            "JOIN rm.mission m " +          // JPQL: rm.mission (ReceivedMission.mission 필드)
            "JOIN m.store s " +             // JPQL: m.store (Mission.store 필드)
            "WHERE rm.member.id = :memberId " + // JPQL: rm.member.id (ReceivedMission.member 필드)
            "ORDER BY CASE WHEN rm.status = '진행중' THEN 1 ELSE 2 END, rm.updatedAt DESC")
    Page<MyMissionDTO> findMyMissions(@Param("memberId") Long memberId, Pageable pageable);
}