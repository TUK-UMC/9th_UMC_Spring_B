package com.umc.umc.domain.store.service;

import com.umc.umc.domain.store.converter.RegionConverter;
import com.umc.umc.domain.store.dto.req.RegionCreateRequest;
import com.umc.umc.domain.store.dto.res.RegionCreateResponse;
import com.umc.umc.domain.store.entity.Region;
import com.umc.umc.domain.store.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionConverter regionConverter;

    @Override
    public RegionCreateResponse regionCreate(RegionCreateRequest request) {
        Region newRegion = regionConverter.toRegionEntity(request);

        newRegion = regionRepository.save(newRegion);

        return regionConverter.toRegionCreateResponse(newRegion);
    }
}
