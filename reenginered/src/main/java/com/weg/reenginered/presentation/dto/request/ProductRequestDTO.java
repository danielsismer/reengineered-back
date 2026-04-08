package com.weg.reenginered.presentation.dto.request;

import com.weg.reenginered.domain.entity.Category;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price,
        Long category_id,
        String urlImage,
        Integer quantity
) {
}
