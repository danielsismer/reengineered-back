package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.user.UserFacade;
import com.weg.reenginered.application.usecase.user.SaveUserUseCase;
import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.presentation.dto.request.UserRequestDTO;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="User", description = "Endpoints for User management")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @Operation(summary = "Create a new User")
    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO userRequestDTO){
        return ResponseEntity
                .status(201)
                .body(userFacade.save(userRequestDTO));
    }

    @Operation(summary = "Find User by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(userFacade.findById(id));
    }

    @Operation(summary = "List All Users")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(@ModelAttribute UserFilter userFilter){
        return ResponseEntity
                .status(200)
                .body(userFacade.findAll(userFilter));
    }

    @Operation(summary = "Delete User by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userFacade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(summary = "Update User by id")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity
                .status(200)
                .body(userFacade.update(id, userRequestDTO));
    }

}
