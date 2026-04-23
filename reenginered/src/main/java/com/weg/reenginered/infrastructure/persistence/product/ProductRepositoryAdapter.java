package com.weg.reenginered.infrastructure.persistence.product;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.exception.category.CategoryNotFound;
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
    private final CategoryMapper categoryMapper;

    @Override
    public List<Product> findAll(ProductFilter productFilter) {
        return repository.findAll(ProductSpec.filter(productFilter))
                .stream()
                .map(
                        productJpa -> {
                            Product product = mapper.toEntity(productJpa);
                            Category category = categoryMapper.toEntity(productJpa.getCategory());
                            product.setId(productJpa.getId());
                            product.setCategory(category);
                            return product;
                        }
                )
                .toList();
    }

    @Override
    public Product findById(Long id) {

        ProductJpa productJpa = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));

        Product productGenerated = mapper.toEntity(productJpa);
        productGenerated.setCategory(categoryMapper.toEntity(productJpa.getCategory()));
        productGenerated.setId(productJpa.getId());

        return productGenerated;
    }

    @Override
    public Product save(Product product) {
        ProductJpa productJpa = mapper.toJpa(product);
        CategoryJpa categoryRef = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new CategoryNotFound(product.getCategory().getId()));
        productJpa.setCategory(categoryRef);

        Product productSaved = mapper.toEntity(repository.save(productJpa));
        productSaved.setCategory(categoryMapper.toEntity(categoryRef));
        return productSaved;
    }

    @Override
    public Product update(Product product, Long id) {

        ProductJpa productJpa = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));

        CategoryJpa categoryRef = categoryRepository.getReferenceById(product.getCategory().getId());

        productJpa.setName(product.getName());
        productJpa.setPrice(product.getPrice());
        productJpa.setCategory(categoryRef);
        productJpa.setUrlImage(product.getUrlImage());
        productJpa.setQuantity(product.getQuantity());
        productJpa.setDescription(product.getDescription());

        ProductJpa productSaved = repository.save(productJpa);
        Product productGenerated = mapper.toEntity(productJpa);

        productGenerated.setCategory(
                categoryMapper.toEntity(productSaved.getCategory()));
        productGenerated.setId(productSaved.getId());

        return productGenerated;
    }

    @Override
    public void deleteById(Long id) {
        ProductJpa product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));

        repository.deleteById(id);
    }
}