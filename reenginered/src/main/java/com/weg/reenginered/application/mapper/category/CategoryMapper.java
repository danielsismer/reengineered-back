package com.weg.reenginered.application.mapper.category;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO categoryRequestDTO){
        return new Category(
                categoryRequestDTO.name()
        );
    }

    public CategoryResponseDTO toResponse(Category category, List<String> productNames){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                productNames
        );
    }

    public Category toEntity(CategoryJpa categoryJpa, List<Product> products){
        return new Category(
            categoryJpa.getId(),
            categoryJpa.getName(),
            products
        );
    }

    public CategoryJpa toJpa(Category category){
        CategoryJpa categoryJpa = new CategoryJpa();
        categoryJpa.setName(category.getName());
        return categoryJpa;
    }
}
