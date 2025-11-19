package com.example.chapter6.domain.mission.repository;

import com.example.chapter6.domain.mission.dto.HomeMissionDTO;
import com.example.chapter6.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    /**
     * 홈 화면 - 도전 가능 미션 목록 조회 (페이징 포함)
     * (SQL: SELECT m.id, s.name, ... FROM Mission m ... WHERE s.area_id = ? AND rm.id IS NULL)
     */

    // JPQL 쿼리 본문입니다. Spring Data JPA가 이 문자열을 해석하여 SQL로 실행합니다.
    @Query(value = "SELECT new com.example.chapter6.domain.mission.dto.HomeMissionDTO(m.id, s.name, s.description, m.description, m.reward) " + // [1] SELECT 절

            "FROM Mission m " +                                          // [2] FROM 절: Mission 엔티티(m)를 기준으로 조회 시작

            "JOIN m.store s " +                                          // [3] JOIN 절: Mission(m)의 store 필드를 이용해 Store(s)와 조인

            "LEFT JOIN ReceivedMission rm ON rm.mission = m AND rm.member.id = :memberId " + // [4] LEFT JOIN 절: ReceivedMission(rm)과 조인.
            // SQL처럼 '내가 받은 미션'인지 확인하기 위해 ON 절에 memberId 조건 추가

            "WHERE s.area.id = :areaId AND rm.id IS NULL " +             // [5] WHERE 절:
            //  - s.area.id = :areaId: Store(s)의 area 필드를 통해 Area ID가 파라미터(areaId)와 일치하는지 (지역 필터링)
            //  - rm.id IS NULL: [4]번 조인 결과 ReceivedMission이 없는 것(rm.id가 NULL)만 필터링 (아직 받지 않은 미션)

            "ORDER BY m.createdAt DESC", // [6] ORDER BY 절: 미션 생성일(createdAt) 기준 내림차순 정렬

            // [7] COUNT 쿼리: 페이징 처리를 위해 '전체 결과 수'를 세는 쿼리.
            //     JOIN이 복잡할 경우, Spring Data JPA가 자동으로 생성하는 COUNT 쿼리보다 직접 작성하는 것이 더 효율적입니다.
            countQuery = "SELECT COUNT(m) " +
                    "FROM Mission m " +
                    "JOIN m.store s " +
                    "LEFT JOIN ReceivedMission rm ON rm.mission = m AND rm.member.id = :memberId " +
                    "WHERE s.area.id = :areaId AND rm.id IS NULL")

    // [8] 메서드 선언:
    Page<HomeMissionDTO> findChallengeableMissions(
            @Param("memberId") Long memberId,   // JPQL의 :memberId 부분에 이 값을 주입
            @Param("areaId") Long areaId,       // JPQL의 :areaId 부분에 이 값을 주입
            Pageable pageable                  // 페이징 정보 (페이지 번호, 페이지 크기)
    );
}