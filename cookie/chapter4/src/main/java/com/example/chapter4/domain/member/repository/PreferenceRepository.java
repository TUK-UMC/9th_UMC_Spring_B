package com.example.chapter4.domain.member.repository;

import com.example.chapter4.domain.member.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

// com.example.chapter4.domain.member.repository.PreferenceRepository
public interface PreferenceRepository extends JpaRepository<Preference, Long> { }
