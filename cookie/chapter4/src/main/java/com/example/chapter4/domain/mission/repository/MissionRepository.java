// mission/repository/MissionRepository.java
package com.example.chapter4.domain.mission.repository; // (패키지 경로는 예시입니다)

import com.example.chapter4.domain.mission.dto.MyMissionDTO;
import com.example.chapter4.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    /**
     * [리팩토링] 홈 화면 My Mission 목록 조회 (DTO + 페이징)
     *
     * 1. LEFT JOIN ... ON ... AND ... 구문을 JPQL로 변환합니다.
     * 2. WHERE 절에서 s.area.id (가정)를 사용합니다.
     * 3. LIMIT/OFFSET 대신 Pageable 파라미터를 받아 페이징을 자동 처리합니다.
     * 4. rm.deadline은 rm.id IS NULL 조건에 의해 항상 null입니다.
     */
    @Query("SELECT new com.example.chapter4.domain.mission.dto.MyMissionDTO(m.id, s.name, s.category, m.description, m.reward, rm.deadline) " +
            "FROM Mission m " +
            "JOIN m.store s " +
            "LEFT JOIN ReceivedMission rm ON rm.mission = m AND rm.member.id = :memberId " +
            "WHERE s.area.id = :areaId AND rm.id IS NULL " +
            "ORDER BY m.createdAt DESC") // (ORDER BY는 JPQL 쿼리에 남겨둡니다)
    Page<MyMissionDTO> findMyMissionList(@Param("memberId") Long memberId,
                                         @Param("areaId") Long areaId,
                                         Pageable pageable);

}