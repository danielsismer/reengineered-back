package com.weg.reenginered.application.mapper.product;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product toEntity(ProductRequestDTO productRequestDTO) {
        return new Product(
                productRequestDTO.name(),
                productRequestDTO.price(),
                productRequestDTO.urlImage(),
                productRequestDTO.quantity(),
                productRequestDTO.description()
        );
    }

    public Product toEntity(ProductJpa productJpa) {
        return new Product(
                productJpa.getName(),
                productJpa.getPrice(),
                productJpa.getUrlImage(),
                productJpa.getQuantity(),
                productJpa.getDescription()
        );
    }

    public ProductResponseDTO toResponse(Product product, CategoryResponseDTO category, List<Long> stockIds) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                category,
                stockIds,
                product.getUrlImage(),
                product.getQuantity(),
                product.getDescription()
        );
    }

    public ProductJpa toJpa(Product product, CategoryJpa categoryJpa, List<StockJpa> stocksJpa) {
        return new ProductJpa(
                product.getName(),
                product.getPrice(),
                categoryJpa,
                stocksJpa,
                product.getUrlImage(),
                product.getQuantity(),
                product.getDescription()
        );
    }
}