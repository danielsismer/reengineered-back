package com.weg.reenginered.infrastructure.persistence.stock.spec;

import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class StockSpec {

    public static Specification<StockJpa> filterDateArrival(LocalDateTime dateArrival){
        return (root, query, criteriaBuilder) -> {
            if(dateArrival == null ) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("dateArrival")), String.valueOf(dateArrival));
        };
    }

    public static Specification<StockJpa> filterAll(StockFilter stockFilter){
        return Specification.where(filterDateArrival(stockFilter.getDateArrival()));
    }
}
