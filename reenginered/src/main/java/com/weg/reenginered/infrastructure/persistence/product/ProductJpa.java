package com.weg.reenginered.infrastructure.persistence.product;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.infrastructure.persistence.category.CategoryJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryJpa category;

    public ProductJpa(String name, BigDecimal price, CategoryJpa category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
