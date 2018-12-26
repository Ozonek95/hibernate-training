package com.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_id")
    private int priceId;
    private double value;
    private String currency;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "price")
    private Set<Product> product;

    public Price(float value, String currency) {
        this.value = value;
        this.currency = currency;
        this.product= new HashSet<>();
    }
    private Price(){
        this.product= new HashSet<>();
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceId=" + priceId +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getValue() {
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
