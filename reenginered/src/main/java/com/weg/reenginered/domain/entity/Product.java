package com.weg.reenginered.domain.entity;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private List<Stock> stocks;

    public Product(Long id, String name, BigDecimal price, Category category, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stocks = stocks;
    }

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
