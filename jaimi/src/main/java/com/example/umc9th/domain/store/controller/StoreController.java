package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.exception.code.StoreSuccessCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.umc9th.domain.store.service.StoreService;
import com.example.umc9th.domain.store.dto.StoreResponseDto;
import com.example.umc9th.domain.store.exception.code.StoreSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController implements StoreControllerDocs {

    private final StoreService storeService;

    @Override
    @GetMapping("/{name}")
    public ApiResponse<StoreResponseDto.StoreInfoDTO> getStoreByName(@PathVariable String name){

        StoreResponseDto.StoreInfoDTO dto = storeService.findByName(name);

        return ApiResponse.onSuccess(StoreSuccessCode.STORE_FOUND, dto);
    }
}
