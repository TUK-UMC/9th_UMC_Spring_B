package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {}
