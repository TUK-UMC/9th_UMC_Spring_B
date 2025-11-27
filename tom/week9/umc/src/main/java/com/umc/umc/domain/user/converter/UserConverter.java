package com.umc.umc.domain.user.converter;

import com.umc.umc.domain.user.dto.req.UserReqDto;
import com.umc.umc.domain.user.dto.res.UserResDto;
import com.umc.umc.domain.user.entity.User;
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
            UserReqDto dto
    ){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .birth(dto.getBirth())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

}
