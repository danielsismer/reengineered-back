package com.weg.reenginered.presentation.dto.response;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String password
) {
}
