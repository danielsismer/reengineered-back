package com.weg.reenginered.domain.exception.user;

import com.weg.reenginered.domain.exception.DomainException;
import org.springframework.http.HttpStatus;

public class UserNotFound extends DomainException {

    public UserNotFound(Long id){
        super("User not found by ID: " + id, HttpStatus.NOT_FOUND.value());
    }

}

