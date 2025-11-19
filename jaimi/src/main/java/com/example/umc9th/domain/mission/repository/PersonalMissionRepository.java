package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.PersonalMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalMissionRepository extends JpaRepository<PersonalMission, Long> {
}
