package com.umc.umc.domain.store.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StoreToRegionCreateResponse {
    private Long StoreId;
    private LocalDateTime createTime;
}
