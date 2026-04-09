package com.weg.reenginered.application.mapper.local;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import com.weg.reenginered.presentation.dto.request.LocalRequestDTO;
import com.weg.reenginered.presentation.dto.response.LocalResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalMapper {

    public Local toEntity(LocalRequestDTO localRequestDTO){
        return new Local(
                localRequestDTO.name(),
                localRequestDTO.floor()
        );
    }

    public Local toEntity(LocalJpa localJpa, List<Stock> stocks){
        return new Local(
                localJpa.getId(),
                localJpa.getName(),
                localJpa.getFloor(),
                stocks
        );
    }

    public LocalResponseDTO toResponse(Local local, List<Long> stockIds){
        return new LocalResponseDTO(
                local.getId(),
                local.getName(),
                local.getFloor(),
                stockIds
        );
    }

    public LocalJpa toJpa(Local local, List<StockJpa> stocksJpa){
        return new LocalJpa(
                local.getId(),
                local.getName(),
                local.getFloor(),
                stocksJpa
        );
    }
}
