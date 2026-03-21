package com.weg.reenginered.domain.exception.product;

import com.weg.reenginered.domain.exception.DomainException;
import org.springframework.http.HttpStatus;

public class ProductNotFound extends DomainException {

    public ProductNotFound(Long id){
        super("Product not found by ID: " + id, HttpStatus.NOT_FOUND.value());
    }

}
