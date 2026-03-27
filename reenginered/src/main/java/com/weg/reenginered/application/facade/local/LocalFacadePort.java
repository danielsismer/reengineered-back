package com.weg.reenginered.application.facade.local;

import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.presentation.dto.request.LocalRequestDTO;
import com.weg.reenginered.presentation.dto.response.LocalResponseDTO;

import java.util.List;

public interface LocalFacadePort {

    LocalResponseDTO save(LocalRequestDTO local);
    LocalResponseDTO listById(Long id);
    List<LocalResponseDTO> listAll(LocalFilter localFilter);
    LocalResponseDTO update(LocalRequestDTO local, Long id);
    void deleteById(Long id);
}
