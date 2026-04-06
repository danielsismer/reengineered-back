package com.weg.reenginered.infrastructure.persistence.stock;

import com.weg.reenginered.application.mapper.local.LocalMapper;
import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.application.mapper.stock.StockMapper;
import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.domain.exception.local.LocalNotFoundException;
import com.weg.reenginered.domain.exception.stock.StockNotFound;
import com.weg.reenginered.domain.port.StockPort;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.infrastructure.persistence.stock.spec.StockSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StockRepositoryAdapter implements StockPort {

    private final StockJpaRepository repository;
    private final StockMapper mapper;
    private final ProductMapper productMapper;
    private final LocalMapper localMapper;

    @Override
    public List<Stock> findAll(StockFilter stockFilter) {
        return repository.findAll(StockSpec.filterAll(stockFilter))
                .stream()
                .map(mapper::toEntity)
                .toList();
    }

    @Override
    public Stock findById(Long id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElseThrow( () -> new StockNotFound(id));
    }

    @Override
    public Stock save(Stock stock) {
        return mapper.toEntity(repository.save(mapper.toJpa(stock)));
    }

    @Override
    public Stock update(Stock stock, Long id) {
        StockJpa stockJpa = repository.findById(id)
                .orElseThrow( () -> new LocalNotFoundException(id));

        ProductJpa productJpa = productMapper.toJpa(stock.getProduct());
        LocalJpa localJpa = localMapper.toJpa(stock.getLocal());

        stockJpa.setProduct(productJpa);
        stockJpa.setLocal(localJpa);

        return mapper.toEntity(repository.save(stockJpa));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
