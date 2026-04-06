package com.weg.reenginered.application.facade.stock;

import com.weg.reenginered.application.mapper.local.LocalMapper;
import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.application.mapper.stock.StockMapper;
import com.weg.reenginered.application.usecase.stock.*;
import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.domain.exception.local.LocalNotFoundException;
import com.weg.reenginered.domain.exception.product.ProductNotFound;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpaRepository;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpaRepository;
import com.weg.reenginered.infrastructure.persistence.product.ProductRepositoryAdapter;
import com.weg.reenginered.presentation.dto.request.StockRequestDTO;
import com.weg.reenginered.presentation.dto.response.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Service
public class StockFacade implements StockFacadePort{

    private final SaveStockUseCase save;
    private final FindStockByIdUseCase findById;
    private final FindStockUseCase findAll;
    private final DeleteStockUseCase deleteById;
    private final UpdateStockUseCase update;

    private final StockMapper mapper;
    private final ProductMapper productMapper;
    private final LocalMapper localMapper;
    private final ProductJpaRepository productRepository;
    private final LocalJpaRepository localRepository;

    @Override
    public StockResponseDTO save(StockRequestDTO stockRequestDTO) {
        ProductJpa product = productRepository.findById(stockRequestDTO.productId())
                .orElseThrow(() -> new ProductNotFound(stockRequestDTO.productId()));

        LocalJpa local = localRepository.findById(stockRequestDTO.LocalId())
                .orElseThrow(() -> new LocalNotFoundException(stockRequestDTO.LocalId()));

        Product productEntity = productMapper.toEntity(product) ;
        Local localEntity = localMapper.toEntity(local);

        Stock stockEntity = mapper.toEntity(productEntity, localEntity);
        stockEntity.setDateArrival(LocalDateTime.now());

        return mapper.toResponse(save.execute(stockEntity));
    }

    @Override
    public List<StockResponseDTO> findAll(StockFilter stockFilter) {
        return findAll.execute(stockFilter)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    @Override
    public StockResponseDTO findById(Long id) {
        return mapper.toResponse(findById.execute(id));
    }

    @Override
    public StockResponseDTO update(StockRequestDTO stockRequestDTO, Long id) {
        ProductJpa product = productRepository.findById(stockRequestDTO.productId())
                .orElseThrow(() -> new ProductNotFound(stockRequestDTO.productId()));

        LocalJpa local = localRepository.findById(stockRequestDTO.LocalId())
                .orElseThrow(() -> new LocalNotFoundException(stockRequestDTO.LocalId()));

        Product productEntity = productMapper.toEntity(product) ;
        Local localEntity = localMapper.toEntity(local);

        return mapper.toResponse(update.execute(mapper.toEntity(productEntity, localEntity), id));
    }

    @Override
    public void deleteById(Long id) {
        deleteById.execute(id);
    }
}
