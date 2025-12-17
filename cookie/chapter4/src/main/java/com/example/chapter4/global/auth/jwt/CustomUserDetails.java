package com.example.chapter4.global.auth.jwt;

import com.example.chapter4.domain.member.entity.Member;

import java.util.Collection;

public class CustomUserDetails {
    public CustomUserDetails(Member member) {

    }

    public String getUsername() {
        return null;
    }

    public Collection<Object> getAuthorities() {
        return null;
    }
}
