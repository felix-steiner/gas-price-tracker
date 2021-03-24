package com.gaspricetracker.gaspricetracker.models;

public class GasPriceDTO {
    Double price;
    long createdAt;

    public GasPriceDTO(Double price, long createdAt) {
        this.price = price;
        this.createdAt = createdAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public GasPriceDTO() {


    }
}

