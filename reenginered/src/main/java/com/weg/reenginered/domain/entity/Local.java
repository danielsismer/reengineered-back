package com.weg.reenginered.domain.entity;

import java.util.List;

public class Local {

    private Long id;
    private String name;
    private Integer floor;
    private List<Stock> stocks;

    public Local(Long id, String name, Integer floor, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.stocks = stocks;
    }

    public Local(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public Local(){}

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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
