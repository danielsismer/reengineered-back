package com.weg.reenginered.infrastructure.persistence.product.spec;

import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {

    public static Specification<ProductJpa> filterName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank()) return null;
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
            );
        };
    }

    public static Specification<ProductJpa> filterMinPrice(BigDecimal minPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null) return null;
            return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
        };
    }

    public static Specification<ProductJpa> filterMaxPrice(BigDecimal maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (maxPrice == null) return null;
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }

    public static Specification<ProductJpa> filter(ProductFilter productFilter) {
        return Specification
                .where(filterMinPrice(productFilter.getMinPrice()))
                .and(filterMaxPrice(productFilter.getMaxPrice()))
                .and(filterName(productFilter.getName()));
    }
}
