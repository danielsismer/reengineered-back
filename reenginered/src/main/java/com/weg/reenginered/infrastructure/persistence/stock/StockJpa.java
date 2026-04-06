package com.weg.reenginered.infrastructure.persistence.stock;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.infrastructure.persistence.local.LocalJpa;
import com.weg.reenginered.infrastructure.persistence.product.ProductJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJpa product;

    @Column(nullable = false)
    private LocalDateTime dateArrival;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private LocalJpa local;
}
