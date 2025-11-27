package com.example.umc9th.domain.store.service.query;

import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;

    @Override
    public StoreResponseDto.StoreInfoDTO finByName(String name){
        Store store = storeRepository.findByName(name).orElseThrow(() -> new StoreNotFoundException());

        return StoreResponseDto.StoreInfoDTO.of(store);
    }
}
