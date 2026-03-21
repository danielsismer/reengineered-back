package com.weg.reenginered.application.mapper;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.infrastructure.persistence.user.UserJpa;
import com.weg.reenginered.presentation.dto.request.UserRequestDTO;
import com.weg.reenginered.presentation.dto.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO){
        return new User(
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.password()
        );
    }

    public UserResponseDTO toResponse(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public UserJpa toJpa(User user) {
        UserJpa jpa = new UserJpa();
        jpa.setEmail(user.getEmail());
        jpa.setName(user.getName());
        jpa.setPassword(user.getPassword());
        return jpa;
    }

    public User toEntity(UserJpa jpa) {
        return new User(
                jpa.getId(),
                jpa.getEmail(),
                jpa.getName(),
                jpa.getPassword()
        );
    }



}
