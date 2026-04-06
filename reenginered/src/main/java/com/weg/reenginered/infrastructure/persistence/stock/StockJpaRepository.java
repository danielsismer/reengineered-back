package com.weg.reenginered.infrastructure.persistence.stock;

import com.weg.reenginered.domain.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StockJpaRepository extends JpaRepository<StockJpa, Long>, JpaSpecificationExecutor<StockJpa> {
}
