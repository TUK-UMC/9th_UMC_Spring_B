package com.umc.umc.domain.store.controller;

import com.umc.umc.domain.store.dto.req.StoreToRegionCreateRequest;
import com.umc.umc.domain.store.dto.res.StoreToRegionCreateResponse;
import com.umc.umc.domain.store.exception.code.StoreSuccessCode;
import com.umc.umc.domain.store.service.StoreService;
import com.umc.umc.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/regions/{regionId}/stores")
    public ApiResponse<StoreToRegionCreateResponse> addStore(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreToRegionCreateRequest request
    ) {
        StoreToRegionCreateResponse storeCreateResponse = storeService.storeCreate(regionId, request);
        return ApiResponse.success(StoreSuccessCode.CREATED, storeCreateResponse);
    }
}
