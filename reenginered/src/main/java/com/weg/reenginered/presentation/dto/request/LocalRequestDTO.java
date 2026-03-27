package com.weg.reenginered.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LocalRequestDTO(

        @NotBlank
        String name,

        @NotNull @Positive
        Integer floor
) {
}
