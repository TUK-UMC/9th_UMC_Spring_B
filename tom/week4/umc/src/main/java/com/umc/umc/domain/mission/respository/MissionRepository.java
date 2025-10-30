package com.umc.umc.domain.mission.respository;

import com.umc.umc.domain.mission.dto.AvailableMissionDto;
import com.umc.umc.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    @Query(
            "SELECT new com.umc.umc.domain.mission.dto.AvailableMissionDto(s.name, m.title, m.description) " +
                    "FROM Mission m " +
                    "JOIN m.store s " +
                    "JOIN s.region r " +
                    "WHERE r.id = :regionId " +
                    "AND NOT EXISTS (" +
                    "SELECT 1 FROM MissionStatus ms " +
                    "WHERE ms.mission = m " +
                    "AND ms.user.id = :userId" +
                    ") " +
                    "ORDER BY m.id DESC"
    )
    Page<AvailableMissionDto> findAvailableMissions(
            @Param("regionId") Long regionId,
            @Param("userId") Long userId,
            Pageable pageable
    );
}

