package com.weg.reenginered.domain.entity;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private String urlImage;
    private Integer quantity;
    private String description;

    public Product(Long id, String name, BigDecimal price, Category category, String urlImage, Integer quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.urlImage = urlImage;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(String name, BigDecimal price, Category category, String urlImage, Integer quantity, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.urlImage = urlImage;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
