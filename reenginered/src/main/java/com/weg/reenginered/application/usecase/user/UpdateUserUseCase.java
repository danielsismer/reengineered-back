package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UpdateUserUseCase {

    private final UserPort repository;

    public User execute(Long id, User user){
        return repository.update(id, user);
    }

}
