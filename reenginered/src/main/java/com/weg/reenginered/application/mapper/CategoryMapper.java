package com.weg.reenginered.application.mapper;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO categoryRequestDTO){
        return new Category(
                categoryRequestDTO.name()
        );
    }

    public CategoryResponseDTO toResponse(Category category){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName()
        );
    }

    public Category toEntity(CategoryJpa categoryJpa){
        return new Category(

        );
    }
}
