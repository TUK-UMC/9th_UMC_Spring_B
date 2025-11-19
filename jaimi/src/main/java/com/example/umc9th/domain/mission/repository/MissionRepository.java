package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<mission, Long> {}