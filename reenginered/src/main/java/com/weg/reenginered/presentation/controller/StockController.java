package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.stock.StockFacadePort;
import com.weg.reenginered.domain.dto.filter.StockFilter;
import com.weg.reenginered.presentation.dto.request.StockRequestDTO;
import com.weg.reenginered.presentation.dto.response.StockResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stock", description = "Endpoints for Stock management")
@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockFacadePort facade;

    @Operation(summary = "Create a new Stock")
    @PostMapping
    public ResponseEntity<StockResponseDTO> save(@RequestBody @Valid StockRequestDTO stockRequestDTO){
        return ResponseEntity
                .status(200)
                .body(facade.save(stockRequestDTO));
    }

    @Operation(summary = "List all Stocks")
    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> listAll(@ModelAttribute StockFilter stockFilter){
        return ResponseEntity
                .status(200)
                .body(facade.findAll(stockFilter));
    }

    @Operation(summary = "Find Stock by id")
    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.findById(id));
    }

    @Operation(summary = "Delete Stock by id")
    @GetMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        facade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(summary = "Update Stock by id")
    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> update(@RequestBody @Valid StockRequestDTO stockRequestDTO,
                                                   @PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(facade.update(stockRequestDTO, id));
    }

}
