package com.weg.reenginered.domain.exception.local;

import com.weg.reenginered.domain.exception.DomainException;
import org.springframework.http.HttpStatus;

public class LocalNotFoundException extends DomainException {

    public LocalNotFoundException(Long id) {
        super("Local not found by ID: " + id, HttpStatus.NOT_FOUND.value());
    }
}
