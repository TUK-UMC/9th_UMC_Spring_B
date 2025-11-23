package com.example.umc9th.domain.store.dto;

import com.example.umc9th.domain.store.entity.Store;

public class StoreResponseDto {
    public record StoreInfoDTO(
            Long id,
            String name,
            String address
    ){
        public static StoreInfoDTO of(Store store){
            return new StoreInfoDTO(
                    store.getId(),
                    store.getName(),
                    store.getAddress()
            );
        }
    }
}
