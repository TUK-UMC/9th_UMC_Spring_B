package com.umc.umc.domain.user.converter;

import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.entity.User;
import com.umc.umc.domain.user.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    // Entity -> DTO
    public static UserResDto toJoinDTO(
            User user
    ){
        return UserResDto.builder()
                .userId(user.getId())
                .createTime(user.getCreateTime())
                .build();
    }

    // DTO -> Entity
    public static User toUser(
            UserReqDto dto,
            String password,
            Role role

    ){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(password)
                .role(role)
                .birth(dto.getBirth())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public static UserResDto.LoginDto toLoginDTO(
            User user,
            String accessToken
    ) {
        return new  UserResDto.LoginDto(
                user.getId(),
                accessToken
        );
    }
}
