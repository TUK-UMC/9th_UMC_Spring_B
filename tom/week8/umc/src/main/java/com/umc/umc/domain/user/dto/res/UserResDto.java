package com.umc.umc.domain.user.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResDto{
    Long userId;
    LocalDateTime createTime;

    @Builder
    public UserResDto(Long userId, LocalDateTime createTime) {
        this.userId = userId;
        this.createTime = createTime;
    }
}
