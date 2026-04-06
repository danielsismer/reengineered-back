package com.weg.reenginered.application.usecase.stock;

import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.domain.port.StockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateStockUseCase {

    private final StockPort repository;

    public Stock execute(Stock stock, Long id){
        return repository.update(stock, id);
    }
}
