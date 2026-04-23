package com.weg.reenginered.application.mapper.local;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.presentation.dto.request.LocalRequestDTO;
import com.weg.reenginered.presentation.dto.response.LocalResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class LocalMapper {

    public Local toEntity(LocalRequestDTO localRequestDTO){
        return new Local(
                localRequestDTO.name(),
                localRequestDTO.floor()
        );
    }

    public Local toEntity(LocalJpa localJpa){
        return new Local(
                localJpa.getId(),
                localJpa.getName(),
                localJpa.getFloor()
        );
    }

    public LocalResponseDTO toResponse(Local local){
        return new LocalResponseDTO(
                local.getId(),
                local.getName(),
                local.getFloor()
        );
    }

    public LocalJpa toJpa(Local local){
        return new LocalJpa(
                local.getId(),
                local.getName(),
                local.getFloor()
        );
    }
}
