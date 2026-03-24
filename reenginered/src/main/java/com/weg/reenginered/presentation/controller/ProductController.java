package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.product.ProductFacade;
import com.weg.reenginered.application.facade.product.ProductFacadePort;
import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Endpoints for Product management")
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFacadePort facade;

    @Operation(summary = "Create a new Product")
    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody @Valid ProductRequestDTO productRequestDTO){
        return ResponseEntity
                .status(201)
                .body(facade.save(productRequestDTO));
    }

    @Operation(summary = "List All Products")
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> listAll(@ModelAttribute ProductFilter productFilter){
        return ResponseEntity
                .status(200)
                .body(facade.findAll(productFilter));
    }

    @Operation(summary = "Find Product by id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.findById(id));
    }

    @Operation(summary = "Delete Product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(summary = "Update Product by id")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody @Valid ProductRequestDTO productRequestDTO, @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(productRequestDTO, id));
    }
}
