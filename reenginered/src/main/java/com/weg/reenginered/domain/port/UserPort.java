package com.weg.reenginered.domain.port;

import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.infrastructure.persistence.user.UserJpa;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserPort {

    User findById(Long id);
    List<User> findAll(UserFilter userFilter);
    User save(User user);
    User update(Long id, User user);
    void deleteById(Long id);
}
