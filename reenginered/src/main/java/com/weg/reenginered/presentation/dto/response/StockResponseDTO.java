package com.weg.reenginered.presentation.dto.response;

import java.time.LocalDateTime;

public record StockResponseDTO(
        Long id,
        String productName,
        String localName,
        LocalDateTime dateArrival
) {
}
