package com.weg.reenginered.domain.exception.stock;

import com.weg.reenginered.domain.exception.DomainException;
import org.springframework.http.HttpStatus;

public class StockNotFound extends DomainException {

    public StockNotFound(Long id){
        super("Stock not found by ID: " + id, HttpStatus.NOT_FOUND.value());
    }
}
