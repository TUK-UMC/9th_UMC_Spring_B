package com.umc.umc.domain.store.converter;

import com.umc.umc.domain.store.dto.req.StoreToRegionCreateRequest;
import com.umc.umc.domain.store.dto.res.StoreToRegionCreateResponse;
import com.umc.umc.domain.store.entity.Region;
import com.umc.umc.domain.store.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreConverter {

    public Store toEntity(StoreToRegionCreateRequest request, Region region) {
        return Store.builder()
                .name(request.getStoreName())
                .address(request.getAddress())
                .description(request.getDescription())
                .region(region)
                .build();
    }

    public StoreToRegionCreateResponse toCreateResponse(Store store) {
        return new StoreToRegionCreateResponse(
                store.getId(),
                store.getCreateTime()
        );
    }

}
