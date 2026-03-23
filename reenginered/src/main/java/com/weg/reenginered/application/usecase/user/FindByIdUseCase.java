package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
import com.weg.reenginered.application.mapper.UserMapper;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.exception.user.UserNotFound;
import com.weg.reenginered.domain.port.UserPort;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByIdUseCase {

    private final UserPort repository;

    public User execute(Long id){
        return repository.findById(id);
    }

}
