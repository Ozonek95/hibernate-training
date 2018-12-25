package com.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Price> price = new ArrayList<>();

    private String name;

    @Column(name = "catalog_number")
    private String catalogNumber;
    private String description;

    private Product(){

    }

    public Product(List<Price> price, String name, String catalogNumber) {
        this.price = price;
        this.name=name;
        this.catalogNumber=catalogNumber;
    }

    public Product(String name, String catalogNumber) {
        this.name=name;
        this.catalogNumber=catalogNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
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
