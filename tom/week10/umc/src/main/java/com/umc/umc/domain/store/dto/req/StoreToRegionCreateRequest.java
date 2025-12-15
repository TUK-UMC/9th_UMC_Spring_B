package com.umc.umc.domain.store.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreToRegionCreateRequest {
    private String storeName;
    private String address;
    private String description;
}
