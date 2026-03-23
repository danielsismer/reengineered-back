package com.weg.reenginered.infrastructure.persistence.user;

import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository
        extends JpaRepository<UserJpa, Long>, JpaSpecificationExecutor<UserJpa> {
}