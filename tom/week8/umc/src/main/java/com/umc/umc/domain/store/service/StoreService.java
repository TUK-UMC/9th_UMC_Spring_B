package com.umc.umc.domain.store.service;

import com.umc.umc.domain.store.dto.req.StoreToRegionCreateRequest;
import com.umc.umc.domain.store.dto.res.StoreToRegionCreateResponse;

public interface StoreService {
    StoreToRegionCreateResponse storeCreate(Long regionId, StoreToRegionCreateRequest request);
}
