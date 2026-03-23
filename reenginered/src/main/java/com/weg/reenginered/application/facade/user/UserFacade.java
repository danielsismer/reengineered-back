package com.weg.reenginered.application.facade.user;

import com.weg.reenginered.application.mapper.UserMapper;
import com.weg.reenginered.application.usecase.user.*;
import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.presentation.dto.request.UserRequestDTO;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade implements UserFacadePort {

    private final SaveUserUseCase save;
    private final FindByIdUseCase findById;
    private final FindAllUseCase findAll;
    private final DeleteByIdUseCase deleteById;
    private final UpdateUserUseCase update;
    private final UserMapper mapper;

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = mapper.toEntity(userRequestDTO);
        return mapper.toResponse(save.execute(user));
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return mapper.toResponse(findById.execute(id));
    }

    @Override
    public List<UserResponseDTO> findAll(UserFilter filter) {
        return findAll.execute(filter).stream().map(mapper::toResponse).toList();
    }

    @Override
    public void deleteById(Long id) {
        deleteById.execute(id);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        return mapper.toResponse(update.execute(id, mapper.toEntity(userRequestDTO)));
    }

}
