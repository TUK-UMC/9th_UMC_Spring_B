package com.example.chapter4.domain.store.repository;

import com.example.chapter4.domain.store.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    // 필요하다면 커스텀 쿼리 메서드 추가 가능
}
