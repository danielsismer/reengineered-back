package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.local.LocalFacadePort;
import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.presentation.dto.request.LocalRequestDTO;
import com.weg.reenginered.presentation.dto.response.LocalResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Local", description = "Endpoints for Category management")
@RequiredArgsConstructor
@RestController
@RequestMapping("/local")
public class LocalController {

    private final LocalFacadePort facade;

    @Operation(summary = "Create new Local")
    @PostMapping
    public ResponseEntity<LocalResponseDTO> save(@RequestBody LocalRequestDTO localResponseDTO){
        return ResponseEntity
                .status(201)
                .body(facade.save(localResponseDTO));
    }

    @Operation(summary = "Find Local by id")
    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(201)
                .body(facade.listById(id));
    }

    @Operation(summary = "List all Locals")
    @GetMapping
    public ResponseEntity<List<LocalResponseDTO>> listAll(@ModelAttribute LocalFilter localFilter){
        return ResponseEntity
                .status(201)
                .body(facade.listAll(localFilter));
    }

    @Operation(summary = "Delete Local by id")
    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(summary = "Update Local by id")
    @PutMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> update(@Valid @RequestBody LocalRequestDTO localRequestDTO, @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(localRequestDTO, id));
    }


}
