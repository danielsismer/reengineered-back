package com.weg.reenginered.application.usecase.category;

import com.weg.reenginered.domain.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryByIdUseCase {

    private final CategoryPort repository;

    public void execute(Long id){
        repository.deleteById(id);
    }

}
