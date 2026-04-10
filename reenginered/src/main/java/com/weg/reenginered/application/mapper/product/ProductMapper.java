package com.weg.reenginered.application.mapper.product;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public Product toEntity(ProductRequestDTO productRequestDTO, Category category) {
        return new Product(
                productRequestDTO.name(),
                productRequestDTO.price(),
                null,
                productRequestDTO.urlImage(),
                productRequestDTO.quantity(),
                productRequestDTO.description()
        );
    }

    public Product toEntity(ProductJpa productJpa) {
        return new Product(
                productJpa.getName(),
                productJpa.getPrice(),
                null,
                productJpa.getUrlImage(),
                productJpa.getQuantity(),
                productJpa.getDescription()
        );
    }

    public ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                null,
                product.getUrlImage(),
                product.getQuantity(),
                product.getDescription()
        );
    }

    public ProductJpa toJpa(Product product) {
        return new ProductJpa(
                product.getId(),
                product.getName(),
                product.getPrice(),
                null,
                product.getUrlImage(),
                product.getQuantity(),
                product.getDescription()
        );
    }
}