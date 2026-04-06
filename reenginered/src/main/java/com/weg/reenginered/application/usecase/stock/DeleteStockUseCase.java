package com.weg.reenginered.application.usecase.stock;

import com.weg.reenginered.domain.port.StockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteStockUseCase {

    private final StockPort repository;

    public void execute(Long id){
        repository.deleteById(id);
    }
}
