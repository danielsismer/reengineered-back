package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindProductUseCase {

    private final ProductPort repository;

    public List<Product> execute(ProductFilter filter){
        return repository.findAll(filter);
    }

}
