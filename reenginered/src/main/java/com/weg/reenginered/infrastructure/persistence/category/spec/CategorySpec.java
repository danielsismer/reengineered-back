package com.weg.reenginered.infrastructure.persistence.category.spec;

import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpec {

    public static Specification<CategoryJpa> filterName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name.toLowerCase());
        };
    }

    public static Specification<CategoryJpa> filterAll(CategoryFilter categoryFilter){
        return Specification
                .where(filterName(categoryFilter.getName()));
    }
}
