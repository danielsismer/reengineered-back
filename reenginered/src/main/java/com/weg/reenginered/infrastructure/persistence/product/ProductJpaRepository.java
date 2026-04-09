package com.weg.reenginered.infrastructure.persistence.product;

import com.weg.reenginered.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpa, Long>, JpaSpecificationExecutor<ProductJpa> {

    @Query("SELECT p FROM ProductJpa p JOIN FETCH p.category WHERE p.id = :id")
    Optional<ProductJpa> findByIdWithCategory(@Param("id") Long id);

    @Query("SELECT p FROM ProductJpa p JOIN FETCH p.category WHERE p.category = :category")
    List<ProductJpa> findByCategory(@Param("category") Category category);

}
