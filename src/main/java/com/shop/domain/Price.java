package com.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_id")
    private int priceId;
    private float value;
    private String currency;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "price")
    private List<Product> product = new ArrayList<>();

    public Price(float value, String currency) {
        this.value = value;
        this.currency = currency;
    }
    private Price(){}

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
