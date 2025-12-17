package com.example.umc9th.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import com.example.umc9th.domain.member.Gender;
import java.time.LocalDate;



public record MemberReqDTO() {

    @Builder
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password

    ){}
    @Builder
    public record JoinDTO(
            @NotBlank
            String name,

            @Email
            String email,

            @NotBlank
            String password,

            @NotNull
            Gender gender,

            @NotNull
            LocalDate birth,

            @NotNull String address,
            @NotNull String specAddress

    ) {}
}
