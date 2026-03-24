package com.weg.reenginered.domain.port;

import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Product;

import java.util.List;

public interface ProductPort {

    List<Product> findAll(ProductFilter productFilter);
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product, Long id);
    void deleteById(Long id);
}
