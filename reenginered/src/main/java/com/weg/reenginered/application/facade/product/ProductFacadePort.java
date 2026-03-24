package com.weg.reenginered.application.facade.product;

import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductFacadePort {

    ProductResponseDTO save(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> findAll(ProductFilter productFilter);
    ProductResponseDTO findById(Long id);
    ProductResponseDTO update(ProductRequestDTO productRequestDTO, Long id);
    void deleteById(Long id);

}
