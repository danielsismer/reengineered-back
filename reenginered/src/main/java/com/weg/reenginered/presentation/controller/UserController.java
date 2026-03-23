package com.weg.reenginered.presentation.controller;

import com.weg.reenginered.application.facade.user.UserFacade;
import com.weg.reenginered.application.usecase.user.SaveUserUseCase;
import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.presentation.dto.request.UserRequestDTO;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO userRequestDTO){
        return ResponseEntity
                .status(201)
                .body(userFacade.save(userRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(userFacade.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(@ModelAttribute UserFilter userFilter){
        return ResponseEntity
                .status(200)
                .body(userFacade.findAll(userFilter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userFacade.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity
                .status(200)
                .body(userFacade.update(id, userRequestDTO));
    }

}
