package com.weg.reenginered.application.facade.local;

import com.weg.reenginered.application.mapper.local.LocalMapper;
import com.weg.reenginered.application.usecase.local.*;
import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.presentation.dto.request.LocalRequestDTO;
import com.weg.reenginered.presentation.dto.response.LocalResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Component
@Service
public class LocalFacade implements LocalFacadePort{

    private final SaveLocalUseCase save;
    private final FindLocalUseCase findAll;
    private final FindLocalByIdUseCase findById;
    private final UpdateLocalUseCase update;
    private final DeleteLocalUseCase deleteById;

    private final LocalMapper mapper;

    @Override
    public LocalResponseDTO save(LocalRequestDTO local) {
        return mapper.toResponse(save.execute(mapper.toEntity(local)));
    }

    @Override
    public LocalResponseDTO listById(Long id) {
        return mapper.toResponse(findById.execute(id));
    }

    @Override
    public List<LocalResponseDTO> listAll(LocalFilter localFilter) {
        return findAll.execute(localFilter)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public LocalResponseDTO update(LocalRequestDTO local, Long id) {
        return mapper.toResponse(update.execute(mapper.toEntity(local), id));
    }

    @Override
    public void deleteById(Long id) {
        deleteById.execute(id);
    }
}
