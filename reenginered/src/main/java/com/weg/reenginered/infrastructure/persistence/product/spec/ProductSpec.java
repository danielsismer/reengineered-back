package com.weg.reenginered.infrastructure.persistence.product.spec;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpec {

    public Specification<ProductJpa> filterName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name + "%");
        };
    }

    public Specification<ProductJpa> filterPrice(double price) {
        return (root, query, criteriaBuilder) -> {
            if (price <= 0) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("price")), "%" + price + "%");
        };
    }

    public Specification<ProductJpa> filterCategory(Category category) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" + category + "%");
        };
    }
}