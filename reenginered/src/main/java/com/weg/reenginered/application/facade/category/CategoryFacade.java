package com.weg.reenginered.application.facade.category;

import com.weg.reenginered.application.mapper.category.CategoryMapper;
import com.weg.reenginered.application.usecase.category.DeleteCategoryByIdUseCase;
import com.weg.reenginered.application.usecase.category.FindCategoryByIdUseCase;
import com.weg.reenginered.application.usecase.category.FindCategoryUseCase;
import com.weg.reenginered.application.usecase.category.SaveCategoryUseCase;
import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryFacade implements CategoryFacadePort{

    private final SaveCategoryUseCase save;
    private final FindCategoryByIdUseCase findById;
    private final FindCategoryUseCase findAll;
    private final DeleteCategoryByIdUseCase deleteById;
    private final CategoryMapper mapper;

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO category) {
        return mapper.toResponse(save.execute(mapper.toEntity(category)));
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        return mapper.toResponse(findById.execute(id));
    }

    @Override
    public List<CategoryResponseDTO> listAll(CategoryFilter categoryFilter) {

        return findAll.execute(categoryFilter)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseDTO update(CategoryRequestDTO category, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        deleteById.execute(id);
    }
}
