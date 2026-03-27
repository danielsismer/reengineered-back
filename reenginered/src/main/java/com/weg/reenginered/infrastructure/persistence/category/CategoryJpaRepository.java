package com.weg.reenginered.infrastructure.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryJpa, Long>, JpaSpecificationExecutor<CategoryJpa> {
}
