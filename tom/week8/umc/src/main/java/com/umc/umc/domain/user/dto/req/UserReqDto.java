package com.umc.umc.domain.user.dto.req;

import com.umc.umc.domain.user.enums.Gender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserReqDto {
        String email;
        String name;
        Gender gender;
        LocalDate birth;
        String address;
        String phoneNumber;

        @Builder
        public UserReqDto(String email, String name, Gender gender, LocalDate birth, String address, String phoneNumber) {
            this.email = email;
            this.name = name;
            this.gender = gender;
            this.birth = birth;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }
}
