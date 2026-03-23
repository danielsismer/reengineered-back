package com.weg.reenginered.application.facade.category;

import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CategoryFacadePort {

    CategoryResponseDTO save(CategoryRequestDTO category);
    CategoryResponseDTO findById(Long id);
    List<CategoryResponseDTO> listAll(CategoryFilter categoryFilter);
    CategoryResponseDTO update(CategoryRequestDTO category, Long id);
    void deleteById(Long id);
}
