package com.umc.umc.domain.store.controller;

import com.umc.umc.domain.store.dto.req.RegionCreateRequest;
import com.umc.umc.domain.store.dto.res.RegionCreateResponse;
import com.umc.umc.domain.store.exception.code.RegionSuccessCode;
import com.umc.umc.domain.store.service.RegionService;
import com.umc.umc.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @PostMapping
    public ApiResponse<RegionCreateResponse> createRegion(
            @RequestBody @Valid RegionCreateRequest request) {

        RegionCreateResponse regionCreateResponse = regionService.regionCreate(request);
        return ApiResponse.success(RegionSuccessCode.CREATED,  regionCreateResponse);
    }

}
