package com.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Price> price;

    private String name;

    @Column(name = "catalog_number")
    private String catalogNumber;
    private String description;

    private Product(){

    }


    public Product(String name, String catalogNumber) {
        this.name=name;
        this.catalogNumber=catalogNumber;
        this.price = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Price> getPrice() {
        return price;
    }

    public void setPrice(Set<Price> price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
