package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.category.CategoryFacadePort;
import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryFacadePort facade;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity
                .status(201)
                .body(facade.save(categoryRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> listAll(@ModelAttribute CategoryFilter categoryFilter){
        return ResponseEntity
                .status(200)
                .body(facade.listAll(categoryFilter));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@RequestBody @Valid CategoryRequestDTO categoryRequestDTO, @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(categoryRequestDTO, id));
    }


}
