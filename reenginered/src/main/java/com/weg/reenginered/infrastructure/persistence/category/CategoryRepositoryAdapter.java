package com.weg.reenginered.infrastructure.persistence.category;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.exception.category.CategoryNotFound;
import com.weg.reenginered.domain.port.CategoryPort;
import com.weg.reenginered.infrastructure.persistence.category.spec.CategorySpec;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryPort {

    private final CategoryJpaRepository repository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category save(Category category) {
        return categoryMapper.toEntity(repository.save(categoryMapper.toJpa(category)));
    }

    @Override
    public Category listById(Long id) {
        return repository.findById(id)
                .map(categoryMapper::toEntity)
                .orElseThrow(() -> new CategoryNotFound(id));
    }

    @Override
    public List<Category> listAll(CategoryFilter categoryFilter) {
        return repository.findAll(CategorySpec.filterAll(categoryFilter))
                .stream()
                .map(categoryMapper::toEntity)
                .toList();

    }

    @Override
    public Category update(Category category, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
