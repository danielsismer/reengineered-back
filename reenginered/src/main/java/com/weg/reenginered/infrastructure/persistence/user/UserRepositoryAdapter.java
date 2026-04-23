package com.weg.reenginered.infrastructure.persistence.user;

import com.weg.reenginered.application.mapper.user.UserMapper;
import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.exception.user.UserNotFound;
import com.weg.reenginered.domain.port.UserPort;
import com.weg.reenginered.infrastructure.persistence.user.spec.UserSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserRepositoryAdapter implements UserPort {

    private final UserJpaRepository repository;
    private final UserMapper mapper;


    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElseThrow(() -> new UserNotFound(id));
    }

    @Override
    public List<User> findAll(UserFilter userFilter) {
        return repository.findAll(UserSpec.filter(userFilter))
                .stream()
                .map(mapper::toEntity)
                .toList();
    }

    @Override
    public User save(User user) {
        UserJpa userJpa = mapper.toJpa(user);
        return mapper.toEntity(repository.save(userJpa));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {

        UserJpa userSearched = repository.findById(id)
                .orElseThrow(() -> new UserNotFound(id));

        userSearched.setName(user.getName());
        userSearched.setPassword(user.getPassword());
        userSearched.setEmail(user.getEmail());

        return mapper.toEntity(repository.save(userSearched));

    }
}
