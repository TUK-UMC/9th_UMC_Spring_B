package com.example.chapter4.domain.member.service;

import com.example.chapter4.domain.member.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @PersistenceContext
    private EntityManager em;

    public Object[] getMyPage(Long id) {
        String jpql = "SELECT m.name, m.email, m.point FROM Member m WHERE m.id = :id";
        return em.createQuery(jpql, Object[].class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
