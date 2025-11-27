package com.example.chapter6.domain.member.dto;

import com.example.chapter6.domain.member.enums.Address;
import com.example.chapter6.domain.member.enums.Gender;
import com.example.chapter6.global.annotation.ExistFoods;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;


import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            String name,
            Gender gender,
            LocalDate birth,
            Address address,
            String specAddress,
            @ExistFoods
            List<Long> preferCategory
    ){}
}
