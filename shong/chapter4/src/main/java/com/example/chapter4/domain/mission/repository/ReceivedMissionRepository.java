// mission/repository/ReceivedMissionRepository.java
package com.example.chapter4.domain.mission.repository;

import com.example.chapter4.domain.mission.dto.MemberMissionDTO;
import com.example.chapter4.domain.mission.entity.ReceivedMission; // (가정)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ReceivedMissionRepository extends JpaRepository<ReceivedMission, Long> {
    /**
     * [리팩토링] 미션중/미션완료 목록 조회 (DTO로 직접 프로젝션)
     *
     * 1. JPQL도 SQL의 'CASE WHEN' 구문을 그대로 지원합니다.
     * 2. JOIN도 테이블명(mission_id)이 아닌 엔티티 필드명(rm.mission)으로 수행합니다.
     * 3. 컬럼명(updated_at) 대신 엔티티 필드명(updatedAt)을 사용합니다.
     */
    @Query("SELECT new com.example.chapter4.domain.mission.dto.MemberMissionDTO(m.reward, s.name, m.description, rm.status, rm.updatedAt) " +
            "FROM ReceivedMission rm " + // (엔티티 ReceivedMission)
            "JOIN rm.mission m " +       // (rm 엔티티의 mission 필드)
            "JOIN m.store s " +          // (m 엔티티의 store 필드)
            "WHERE rm.member.id = :memberId " + // (rm 엔티티의 member 필드)
            "ORDER BY " +
            "  CASE WHEN rm.status = '진행중' THEN 1 ELSE 2 END, " + // 정렬 1순위
            "  rm.updatedAt DESC")                                // 정렬 2순위
    List<MemberMissionDTO> findMyMissions(@Param("memberId") Long memberId);

    @Query("SELECT COUNT(rm) % 10 " +
            "FROM ReceivedMission rm " +
            "WHERE rm.member.id = :memberId AND rm.status = 'completed'")
    Integer findCurrentMissionProgress(@Param("memberId") Long memberId);

}