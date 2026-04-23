package com.weg.reenginered.infrastructure.persistence.local.spec;

import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import org.springframework.data.jpa.domain.Specification;

public class LocalSpec {

    public static Specification<LocalJpa> filterName(String name){
        return (root, query, criteriaBuilder) -> {
            if(name == null || name.isBlank()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name.toLowerCase());
        };
    }

    public static Specification<LocalJpa> filterFloor(Integer floor){
        return (root, query, criteriaBuilder) -> {
            if(floor == null ) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("floor")), String.valueOf(floor));
        };
    }

    public static Specification<LocalJpa> filterAll(LocalFilter localFilter){
        return Specification
                .where(filterName(localFilter.getName()))
                .and(filterFloor(localFilter.getFloor()));
    }
}
