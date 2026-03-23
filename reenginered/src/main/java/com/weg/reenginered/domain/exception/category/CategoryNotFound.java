package com.weg.reenginered.domain.exception.category;

import com.weg.reenginered.domain.exception.DomainException;
import org.springframework.http.HttpStatus;

public class CategoryNotFound extends DomainException {
    public CategoryNotFound(Long id) {
        super("Category not found by ID: " + id, HttpStatus.NOT_FOUND.value());
    }
}
