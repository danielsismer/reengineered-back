package com.weg.reenginered.application.mapper.stock;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.request.StockRequestDTO;
import com.weg.reenginered.presentation.dto.response.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public Stock toEntity(Product product, Local local){
        return new Stock(
                product,
                local);
    }

    public Stock toEntity(StockJpa stockJpa){
        return new Stock(
                stockJpa.getId(),
                stockJpa.getProduct(),
                stockJpa.getDateArrival(),
                stockJpa.getLocal()
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

    public StockJpa toJpa(Stock stock){
        return new StockJpa(
                stock.getId(),
                stock.getProduct(),
                stock.getDateArrival(),
                stock.getLocal()
        );
    }
}
