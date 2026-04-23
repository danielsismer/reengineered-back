package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.category.CategoryFacadePort;
import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.presentation.dto.request.CategoryRequestDTO;
import com.weg.reenginered.presentation.dto.response.CategoryResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category", description = "Endpoints for Category management")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryFacadePort facade;

    @Operation(summary = "Create new Product")
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity
                .status(201)
                .body(facade.save(categoryRequestDTO));
    }

    @Operation(summary = "Find Category by id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.findById(id));
    }

    @Operation(summary = "List all Categories")
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> listAll(@ModelAttribute CategoryFilter categoryFilter){
        return ResponseEntity
                .status(200)
                .body(facade.listAll(categoryFilter));
    }

    @Operation(summary = "Delete Category by id")
    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(summary = "Update Category by id")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@RequestBody @Valid CategoryRequestDTO categoryRequestDTO, @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(categoryRequestDTO, id));
    }


}
