package com.weg.reenginered.infrastructure.persistence.category;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.exception.category.CategoryNotFound;
import com.weg.reenginered.domain.port.CategoryPort;
import com.weg.reenginered.infrastructure.persistence.category.spec.CategorySpec;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryPort {

    private final CategoryJpaRepository repository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;

    @Override
    public Category save(Category category) {
        List<Product> products = category.getProducts();
        return categoryMapper.toEntity(repository.save(categoryMapper.toJpa(category)),products);
    }

    @Override
    public Category listById(Long id) {
        return repository.findById(id)
                .map(
                        categoryJpa -> categoryMapper.toEntity(categoryJpa,
                                categoryJpa.getProducts().stream().map(productMapper::toEntity).toList())
                )
                .orElseThrow(() -> new CategoryNotFound(id));

    }

    @Override
    public List<Category> listAll(CategoryFilter categoryFilter) {
        return repository.findAll(CategorySpec.filterAll(categoryFilter))
                .stream()
                .map( categoryJpa -> categoryMapper.toEntity(categoryJpa, categoryJpa.getProducts().stream().map(productMapper::toEntity).toList())
                )
                .toList();

    }

    @Override
    public Category update(Category category, Long id) {

        CategoryJpa categoryJpa = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFound(id));

        categoryJpa.setName(category.getName());

        return categoryMapper.toEntity(repository.save(categoryJpa), categoryJpa.getProducts().stream().map(productMapper::toEntity).toList());

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
