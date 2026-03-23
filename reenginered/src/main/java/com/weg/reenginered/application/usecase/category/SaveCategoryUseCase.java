package com.weg.reenginered.application.usecase.category;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveCategoryUseCase {

    private final CategoryPort repository;

    public Category execute(Category category){
        return repository.save(category);
    }


}
