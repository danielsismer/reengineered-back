package com.weg.reenginered.application.usecase.category;

import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindCategoryUseCase {

    private final CategoryPort repository;

    public List<Category> execute(CategoryFilter categoryFilter){
        return repository.listAll(categoryFilter);
    }

}
