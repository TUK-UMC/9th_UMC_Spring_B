package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.repository.StoreRepository;
import io.swagger.v3.oas.annotations.Operation;

public interface StoreControllerDocs {
    @Operation(
            summary = "가게 단건 API",
            description = "가게 이름으로 단건 조회합니다."
    )
   @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "200",
                description = "성공"
        ),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "404",
                description = "해당 가게를 찾을 수 없음"
        )
    })
    ApiResponse<StoreResponseDto.StoreInfo> getStoreByName(String name);
}
