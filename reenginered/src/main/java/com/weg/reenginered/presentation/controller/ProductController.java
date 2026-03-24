package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.product.ProductFacade;
import com.weg.reenginered.application.facade.product.ProductFacadePort;
import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.presentation.dto.request.ProductRequestDTO;
import com.weg.reenginered.presentation.dto.response.ProductResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFacadePort facade;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody @Valid ProductRequestDTO productRequestDTO){
        return ResponseEntity
                .status(201)
                .body(facade.save(productRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> listAll(@ModelAttribute ProductFilter productFilter){
        return ResponseEntity
                .status(200)
                .body(facade.findAll(productFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody @Valid ProductRequestDTO productRequestDTO, @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(productRequestDTO, id));
    }
}
