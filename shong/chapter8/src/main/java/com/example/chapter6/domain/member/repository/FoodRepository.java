package com.example.chapter6.domain.member.repository;

import com.example.chapter6.domain.member.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
