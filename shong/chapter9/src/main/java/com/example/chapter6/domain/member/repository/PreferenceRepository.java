package com.example.chapter6.domain.member.repository;

import com.example.chapter6.domain.member.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}