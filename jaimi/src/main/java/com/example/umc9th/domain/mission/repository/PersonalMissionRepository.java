package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.PersonalMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonalMissionRepository extends JpaRepository<PersonalMission, Long> {

    @Query("SELECT pm FROM PersonalMission pm " +
            "JOIN FETCH pm.mission m " +
            "JOIN FETCH m.store s " +
            "WHERE pm.user.id = :userId " +
            "AND pm.progress = :progress")
    Page<PersonalMission> findByUserIdAndProgress(
            @Param("userId") Long userId,
            @Param("progress") String progress,
            Pageable pageable
    );
}
