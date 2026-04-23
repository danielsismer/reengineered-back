package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllUseCase {

    private final UserPort repository;

    public List<User> execute(UserFilter userFilter){
        return repository.findAll(userFilter);
    }
}
