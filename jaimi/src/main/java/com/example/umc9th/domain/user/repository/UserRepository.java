package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    // 현재는 기본 CRUD만으로 충분하므로 추가 메서드 불필요
    // 필요 시 확장 가능 (예: findByEmail, findByName 등)
}
