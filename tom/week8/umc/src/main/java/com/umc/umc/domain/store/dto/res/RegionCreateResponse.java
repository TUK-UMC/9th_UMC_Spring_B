package com.umc.umc.domain.store.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RegionCreateResponse {
    private Long regionId;
    private String name;
    private LocalDateTime createTime;
}
