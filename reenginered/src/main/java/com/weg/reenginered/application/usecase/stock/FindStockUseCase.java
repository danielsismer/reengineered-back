package com.weg.reenginered.application.usecase.stock;

import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.domain.port.StockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindStockUseCase {

    private final StockPort repository;

    public List<Stock> execute(StockFilter stock){
        return repository.findAll(stock);
    }
}
