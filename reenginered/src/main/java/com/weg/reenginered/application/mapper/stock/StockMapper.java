package com.weg.reenginered.application.mapper.stock;

import com.weg.reenginered.application.mapper.local.LocalMapper;
import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import com.weg.reenginered.presentation.dto.response.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMapper {

    public Stock toEntity(Product product, Local local){
        return new Stock(
                product,
                local);
    }

    public Stock toEntity(StockJpa stockJpa, Product product, Local local){

        return new Stock(
                stockJpa.getId(),
                product,
                stockJpa.getDateArrival(),
                local
        );
    }

    public StockResponseDTO toResponse(Stock stock){
        return new StockResponseDTO(
                stock.getId(),
                stock.getProduct().getName(),
                stock.getLocal().getName(),
                stock.getDateArrival()
        );
    }

    public StockJpa toJpa(Stock stock, ProductJpa productJpa, LocalJpa localJpa){

        return new StockJpa(
                stock.getId(),
                productJpa,
                stock.getDateArrival(),
                localJpa
        );
    }
}
