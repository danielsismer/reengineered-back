package com.weg.reenginered.presentation.dto.response;

import java.util.List;

public record CategoryResponseDTO(
        Long id,
        String name,
        List<String> productNames
) {
}
