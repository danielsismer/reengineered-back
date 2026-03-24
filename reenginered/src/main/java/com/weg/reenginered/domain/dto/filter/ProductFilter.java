package com.weg.reenginered.domain.dto.filter;

import com.weg.reenginered.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter {
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
