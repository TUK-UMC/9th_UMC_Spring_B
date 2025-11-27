package com.example.umc9th.domain.store.service.query;

import com.example.umc9th.domain.store.dto.StoreResponseDto;

public interface StoreQueryService {

    StoreResponseDto.StoreInfoDTO findByName(String name);
}
