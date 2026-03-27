package com.weg.reenginered.infrastructure.persistence.local;

import com.weg.reenginered.application.mapper.local.LocalMapper;
import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.exception.local.LocalNotFoundException;
import com.weg.reenginered.domain.port.LocalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LocalRepositoryAdapter implements LocalPort {

    private final LocalJpaRepository repository;
    private final LocalMapper mapper;

    @Override
    public Local save(Local local) {
        return mapper.toEntity(repository.save(mapper.toJpa(local)));
    }

    @Override
    public Local listById(Long id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElseThrow( () -> new LocalNotFoundException(id));
    }

    @Override
    public List<Local> listAll(LocalFilter localFilter) {
        return repository.findAll().stream()
                .map( mapper::toEntity)
                .toList();
    }

    @Override
    public Local update(Local local, Long id) {
        LocalJpa localJpa = repository.findById(id)
                .orElseThrow( () -> new LocalNotFoundException(id));

        localJpa.setName(local.getName());
        localJpa.setFloor(local.getFloor());

        return mapper.toEntity(repository.save(localJpa));
    }

    @Override
    public void deleteById(Long id) {

        repository.deleteById(id);

    }
}
