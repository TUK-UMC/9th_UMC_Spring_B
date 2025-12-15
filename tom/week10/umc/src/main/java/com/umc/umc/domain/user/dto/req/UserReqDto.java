package com.umc.umc.domain.user.dto.req;

import com.umc.umc.domain.user.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.EnumSet;

@Getter
public class UserReqDto {
        String email;
        String password;
        String name;
        Gender gender;
        LocalDate birth;
        String address;
        String phoneNumber;

        @Builder
        public UserReqDto(String email, String password, String name, Gender gender, LocalDate birth, String address, String phoneNumber) {
            this.email = email;
            this.password = password;
            this.name = name;
            this.gender = gender;
            this.birth = birth;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public record LoginDto(
                @NotBlank
                String email,
                @NotBlank
                String password) {
        }


}


