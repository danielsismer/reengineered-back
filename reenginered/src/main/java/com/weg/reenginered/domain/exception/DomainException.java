package com.weg.reenginered.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DomainException extends RuntimeException{

    private final   int httpStatus;

    public DomainException(String message, int httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

}
