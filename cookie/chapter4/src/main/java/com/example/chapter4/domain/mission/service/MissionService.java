package com.example.chapter4.domain.mission.service;

import com.example.chapter4.domain.mission.entity.Mission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissionService {
    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findHomeMission(String address, Long memberId) {
        String jpql = "SELECT m.id, m.description, s.name, s.adress, m.status, m.createdAt " +
                "FROM Mission m JOIN Store s ON m.storeId = s.id " +
                "WHERE m.status = true AND s.adress = :adress AND m.id NOT IN (" +
                "SELECT o.missionId FROM OngoingMission o WHERE o.memberId = :memberId) " +
                "ORDER BY m.createdAt DESC";
        return em.createQuery(jpql, Object[].class)
                .setParameter("adress", address)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
