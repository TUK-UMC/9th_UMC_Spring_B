package com.example.chapter4.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class MemberReqDTO {
    @Builder
    public static class JoinDTO {
        private final String name;
        private final LocalDate birth; // LocalDate 또는 String 등 타입 맞춰서
        private final String address;
        private final String specAddress; // 상세주소 등
        private final String gender;
        private final List<Long> preferredFoodIds;

        // Getter 또는 record 문법 등 사용 가능
        public String name() { return name; }
        public LocalDate birth() { return birth; }
        public String address() { return address; }
        public String specAddress() { return specAddress; }
        public String gender() { return gender; }
        public List<Long> preferredFoodIds() { return preferredFoodIds; }
    }
}
