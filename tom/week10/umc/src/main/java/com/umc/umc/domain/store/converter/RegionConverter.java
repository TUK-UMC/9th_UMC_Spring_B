package com.umc.umc.domain.store.converter;

import com.umc.umc.domain.store.dto.req.RegionCreateRequest;
import com.umc.umc.domain.store.dto.res.RegionCreateResponse;
import com.umc.umc.domain.store.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class RegionConverter {
    public Region toRegionEntity(RegionCreateRequest request) {
        return Region.builder()
                .name(request.getName())
                .build();
    }

    public RegionCreateResponse toRegionCreateResponse(Region region) {
        return new RegionCreateResponse(
                region.getId(),
                region.getName(),
                region.getCreateTime()
        );
    }
}
