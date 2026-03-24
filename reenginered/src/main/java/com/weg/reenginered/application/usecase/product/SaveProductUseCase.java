package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveProductUseCase {

    private final ProductPort repository;

    @Transactional
    public Product execute(Product product){
        return repository.save(product);
    }

}
