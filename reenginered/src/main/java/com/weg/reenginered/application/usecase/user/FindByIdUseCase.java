package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
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
