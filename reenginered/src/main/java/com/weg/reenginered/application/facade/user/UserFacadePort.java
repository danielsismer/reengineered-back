package com.weg.reenginered.application.facade.user;

import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.presentation.dto.request.UserRequestDTO;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;

import java.util.List;

public interface UserFacadePort {

    UserResponseDTO save (UserRequestDTO user);
    UserResponseDTO findById(Long id);
    List<UserResponseDTO> findAll(UserFilter filter);
    void deleteById(Long id);
    UserResponseDTO update(Long id, UserRequestDTO userRequestDTO);
}
