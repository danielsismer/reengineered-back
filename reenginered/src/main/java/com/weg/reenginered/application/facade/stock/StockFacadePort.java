package com.weg.reenginered.application.facade.stock;

import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.presentation.dto.request.StockRequestDTO;
import com.weg.reenginered.presentation.dto.response.StockResponseDTO;

import java.util.List;

public interface StockFacadePort {

    StockResponseDTO save(StockRequestDTO stockRequestDTO);
    List<StockResponseDTO> findAll(StockFilter stockFilter);
    StockResponseDTO findById(Long id);
    StockResponseDTO update(StockRequestDTO stockRequestDTO, Long id);
    void deleteById(Long id);

}
