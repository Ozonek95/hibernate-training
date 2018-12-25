package com.shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "guitar")
public class Guitar {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Handed handed;
    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarManufacturer guitarManufacturer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Handed getHanded() {
        return handed;
    }

    public void setHanded(Handed handed) {
        this.handed = handed;
    }


    public GuitarManufacturer getGuitarManufacturer() {
        return guitarManufacturer;
    }

    public void setGuitarManufacturer(GuitarManufacturer guitarManufacturer) {
        this.guitarManufacturer = guitarManufacturer;
    }

    public Guitar(){

    }

    public Guitar(String name, Handed handed, GuitarManufacturer guitarManufacturer) {
        this.name = name;
        this.handed = handed;
        this.guitarManufacturer = guitarManufacturer;
    }
}
