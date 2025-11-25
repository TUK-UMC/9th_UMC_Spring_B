package com.umc.umc.domain.mission.repository;

import com.umc.umc.domain.mission.dto.res.MissionResponseDto;
import com.umc.umc.domain.mission.entity.Mission;
import com.umc.umc.domain.mission.entity.MissionStatus;
import com.umc.umc.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MissionStatusRepository extends JpaRepository<MissionStatus, Long> {
    @Query(
            "SELECT new com.umc.umc.domain.mission.dto.res.MissionResponseDto$OngoingMissionDto(" +
                    "m.id, m.title, m.description, ms.status, ms.updateTime) " +
                    "FROM MissionStatus ms " +
                    "JOIN ms.mission m " +
                    "JOIN m.store s " +
                    "WHERE ms.user.id = :userId AND ms.status = :status " +
                    "ORDER BY ms.updateTime DESC, ms.id DESC"
    )
    Page<MissionResponseDto.OngoingMissionDto> findOngoingMissionsByUserId(
            @Param("userId") Long userId,
            @Param("status") String status,
            Pageable pageable
    );

    Optional<MissionStatus> findByUserAndMission(User user, Mission mission);


}
