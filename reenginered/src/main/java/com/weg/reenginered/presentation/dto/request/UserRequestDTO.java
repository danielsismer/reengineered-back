package com.weg.reenginered.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.aspectj.weaver.ast.Not;

public record UserRequestDTO (

        @NotBlank
        String name,

        @NotBlank @Email
        String email,

        @NotBlank
        String password
){
}
