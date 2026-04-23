package com.weg.reenginered.infrastructure.persistence.local;

import com.weg.reenginered.domain.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocalJpaRepository extends JpaRepository<LocalJpa, Long>, JpaSpecificationExecutor<LocalJpa> {
}
