package com.example.chapter6.domain.store.repository;

import com.example.chapter6.domain.store.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}