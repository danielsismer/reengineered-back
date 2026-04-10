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

    @Column(name = "url_image",nullable = false)
    private String urlImage;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String description;

    public ProductJpa(String name, BigDecimal price, CategoryJpa category, String urlImage, Integer quantity, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.urlImage = urlImage;
        this.quantity = quantity;
        this.description = description;
    }
}
