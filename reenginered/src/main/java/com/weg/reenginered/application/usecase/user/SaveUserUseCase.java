package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserUseCase {

    private final UserPort repository;

    @Transactional
    public User execute(User user) {
        return repository.save(user);
    }


}
