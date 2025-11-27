package com.umc.umc.domain.store.service;

import com.umc.umc.domain.store.dto.req.RegionCreateRequest;
import com.umc.umc.domain.store.dto.res.RegionCreateResponse;

public interface RegionService {
    public RegionCreateResponse regionCreate(RegionCreateRequest request);
}
