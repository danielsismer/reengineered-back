package com.weg.reenginered.domain.port;

import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.domain.entity.Stock;

import java.util.List;

public interface StockPort {

    List<Stock> findAll(StockFilter stockFilter);
    Stock findById(Long id );
    Stock save(Stock stock);
    Stock update(Stock stock, Long id);
    void deleteById(Long id);


}
