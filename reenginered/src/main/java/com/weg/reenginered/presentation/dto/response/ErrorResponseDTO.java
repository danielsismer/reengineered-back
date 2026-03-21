package com.weg.reenginered.presentation.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDTO(
        LocalDateTime localDateTime,
        int status,
        String message,
        Map<String, String> errors
        ) {
}
