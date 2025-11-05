package com.example.chapter4.domain.mission.repository;

import com.example.chapter4.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 선택된 지역에서 도전 가능한 미션 목록 조회 (페이징)
    @Query("SELECT m FROM Mission m " +
            "WHERE m.store.area.id = :areaId " +
            "ORDER BY m.id DESC")
    Page<Mission> findMissionsByAreaId(@Param("areaId") Long areaId, Pageable pageable);

}
