package com.example.chapter4.domain.review.service;

import com.example.chapter4.domain.review.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findReviewWithMember() {
        String jpql = "SELECT r.rating, r.content, r.photo, r.createdAt FROM Review r LEFT JOIN Member m ON r.memberId = m.id";
        return em.createQuery(jpql, Object[].class).getResultList();
    }
}
