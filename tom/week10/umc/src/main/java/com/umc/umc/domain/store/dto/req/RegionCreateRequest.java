package com.umc.umc.domain.store.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RegionCreateRequest {
    @NotBlank
    private String name;
}
