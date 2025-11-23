package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.umc9th.domain.mission.entity.MissionStatus;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.entity.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, Pageable pageable);

    Page<Mission> findAllByUserAndStatus(user user, MissionStatus status, Pageable pageable);
}