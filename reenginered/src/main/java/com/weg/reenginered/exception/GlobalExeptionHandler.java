package com.weg.reenginered.exception;

import com.weg.reenginered.domain.dto.response.ErrorResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> captureMethodArgument(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error -> {
                            errors.put(error.getField(), error.getDefaultMessage());
                        }
                );

        return buildResponse(HttpStatus.BAD_REQUEST, "Erro ao validar dados. Por favor verifique todos os campos novamente.", errors);

    }

    @ExceptionHandler()

    public ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus status, String message, Map<String, String> errors){

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                message,
                errors
        );

        return ResponseEntity.status(status.value())
                .body(errorResponseDTO);

    }
}
