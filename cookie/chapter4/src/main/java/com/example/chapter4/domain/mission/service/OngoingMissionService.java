package com.example.chapter4.domain.mission.service;

import com.example.chapter4.domain.mission.entity.OngoingMission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OngoingMissionService {
    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findMissions(Long memberId, String status, LocalDateTime before, int offset, int limit) {
        String jpql = "SELECT o.id, m.description, o.createdAt, o.status " +
                "FROM OngoingMission o JOIN Mission m ON o.missionId = m.id " +
                "WHERE o.memberId = :memberId AND o.status = :status AND o.createdAt < :date " +
                "ORDER BY o.createdAt DESC";
        return em.createQuery(jpql, Object[].class)
                .setParameter("memberId", memberId)
                .setParameter("status", status)
                .setParameter("date", before)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
