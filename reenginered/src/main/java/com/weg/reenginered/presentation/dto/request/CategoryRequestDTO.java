package com.weg.reenginered.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank
        String name
) {
}
