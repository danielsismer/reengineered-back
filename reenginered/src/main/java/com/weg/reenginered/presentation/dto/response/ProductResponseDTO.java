package com.weg.reenginered.presentation.dto.response;

import com.weg.reenginered.domain.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO (
        Long id,
        String name,
        BigDecimal price,
        CategoryResponseDTO category,
        List<Long> stockIds,
        String urlImage,
        Integer quantity
){
}
