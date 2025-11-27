package com.umc.umc.domain.store.service;

import com.umc.umc.domain.store.converter.StoreConverter;
import com.umc.umc.domain.store.dto.req.StoreToRegionCreateRequest;
import com.umc.umc.domain.store.dto.res.StoreToRegionCreateResponse;
import com.umc.umc.domain.store.entity.Region;
import com.umc.umc.domain.store.entity.Store;
import com.umc.umc.domain.store.exception.StoreException;
import com.umc.umc.domain.store.repository.RegionRepository;
import com.umc.umc.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.umc.umc.domain.store.exception.code.StoreErrorCode.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final StoreConverter storeConverter;

    @Override
    public StoreToRegionCreateResponse storeCreate(Long regionId, StoreToRegionCreateRequest request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new StoreException(NOT_FOUND));

        Store newStore = storeConverter.toEntity(request, region);
        
        storeRepository.save(newStore);

        return storeConverter.toCreateResponse(newStore);
    }
}
