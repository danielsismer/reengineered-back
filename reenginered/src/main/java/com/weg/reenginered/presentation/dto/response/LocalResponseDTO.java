package com.weg.reenginered.presentation.dto.response;

import java.util.List;

public record LocalResponseDTO(
        Long id,
        String name,
        Integer floor,
        List<Long> stockIds
) {
}
