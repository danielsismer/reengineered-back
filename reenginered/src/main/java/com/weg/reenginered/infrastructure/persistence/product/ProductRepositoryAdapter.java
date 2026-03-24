package com.weg.reenginered.infrastructure.persistence.product;

import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.exception.product.ProductNotFound;
import com.weg.reenginered.domain.port.ProductPort;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpaRepository;
import com.weg.reenginered.infrastructure.persistence.product.spec.ProductSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapter implements ProductPort {

    private final ProductMapper mapper;
    private final ProductJpaRepository repository;
    private final CategoryJpaRepository categoryRepository;

    @Override
    public List<Product> findAll(ProductFilter productFilter) {
        return repository.findAll(ProductSpec.filter(productFilter))
                .stream()
                .map(mapper::toEntity)
                .toList();
    }

    @Override
    public Product findById(Long id) {
        return mapper.toEntity(repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id)));
    }

    @Override
    public Product save(Product product) {
        ProductJpa productJpa = mapper.toJpa(product);
        CategoryJpa categoryRef = categoryRepository.getReferenceById(product.getCategory().getId());
        productJpa.setCategory(categoryRef);

        ProductJpa saved = repository.save(productJpa);
        return mapper.toEntity(saved);
    }

    @Override
    public Product update(Product product, Long id) {

        ProductJpa productJpa = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));

        CategoryJpa categoryRef = categoryRepository.getReferenceById(product.getCategory().getId());

        productJpa.setName(product.getName());
        productJpa.setPrice(product.getPrice());
        productJpa.setCategory(categoryRef);

        return mapper.toEntity(repository.save(productJpa));
    }

    @Override
    public void deleteById(Long id) {
        ProductJpa product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));

        repository.deleteById(id);
    }
}