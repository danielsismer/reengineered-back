package com.weg.reenginered.domain.entity;

import java.time.LocalDateTime;

public class Stock {

    private Long id;
    private Product product;
    private LocalDateTime dateArrival;
    private Local local;

    public Stock(Long id, Product product, LocalDateTime dateArrival, Local local) {
        this.id = id;
        this.product = product;
        this.dateArrival = dateArrival;
        this.local = local;
    }

    public Stock(Product product, LocalDateTime dateArrival, Local local) {
        this.product = product;
        this.dateArrival = dateArrival;
        this.local = local;
    }

    public Stock(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDateTime dateArrival) {
        this.dateArrival = dateArrival;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
