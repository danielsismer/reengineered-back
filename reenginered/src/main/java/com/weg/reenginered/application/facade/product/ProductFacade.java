package com.weg.reenginered.application.facade.product;

import com.weg.reenginered.application.mapper.product.ProductMapper;
import com.weg.reenginered.application.usecase.category.FindCategoryByIdUseCase;
import com.weg.reenginered.application.usecase.product.*;
import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
@Service
public class ProductFacade implements ProductFacadePort {

    private final SaveProductUseCase save;
    private final ProductMapper mapper;
    private final FindCategoryByIdUseCase findCategoryById;
    private final FindProductUseCase findAll;
    private final FindProductByIdUseCase findById;
    private final DeleteProductByIdUseCase deleteById;
    private final UpdateProductUseCase update;


    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Category category = findCategoryById.execute(productRequestDTO.category_id());

        Product product = mapper.toEntity(productRequestDTO);
        product.setCategory(category);
        return mapper.toResponse(save.execute(product));
    }

    @Override
    public List<ProductResponseDTO> findAll(ProductFilter productFilter) {
        return findAll.execute(productFilter)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDTO findById(Long id) {
        return mapper.toResponse(findById.execute(id));
    }

    @Override
    public ProductResponseDTO update(ProductRequestDTO productRequestDTO, Long id) {
        Category category = findCategoryById.execute(productRequestDTO.category_id());
        Product product = mapper.toEntity(productRequestDTO);

        product.setCategory(category);
        product.setId(id);

        return mapper.toResponse(update.execute(product, id));
    }

    @Override
    public void deleteById(Long id) {
        deleteById.execute(id);
    }
}
