package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserByIdUseCase {

    private final UserPort repository;

    public void execute(Long id){
        repository.deleteById(id);
    }

}
