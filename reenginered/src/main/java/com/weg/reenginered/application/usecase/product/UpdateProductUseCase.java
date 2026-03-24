package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final ProductPort repository;

    public Product execute(Product product, Long id){
        return repository.update(product, id);
    }

}
