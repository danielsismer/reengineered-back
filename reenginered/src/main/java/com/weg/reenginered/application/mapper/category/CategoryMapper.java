package com.weg.reenginered.application.mapper.category;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
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
            categoryJpa.getId(),
                categoryJpa.getName()
        );
    }

    public CategoryJpa toJpa(Category category){
        CategoryJpa categoryJpa = new CategoryJpa();
        categoryJpa.setName(category.getName());
        return categoryJpa;
    }
}
