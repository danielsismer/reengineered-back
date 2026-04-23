package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteProductByIdUseCase {

    private final ProductPort repository;


    public void execute(Long id){
        repository.deleteById(id);
    }

}
