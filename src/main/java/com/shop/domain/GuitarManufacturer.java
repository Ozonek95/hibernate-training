package com.shop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guitar_manufacturer")
public class GuitarManufacturer {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    @OneToMany(mappedBy = "guitarManufacturer")
    private Set<Guitar> guitars;

    public GuitarManufacturer(String name) {
        this.name = name;
        this.guitars = new HashSet<>();
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public GuitarManufacturer(){

    }

    public GuitarManufacturer(String name, Set<Guitar> guitars) {
        this.name = name;
        this.guitars = guitars;
    }

    @Override
    public String toString() {
        return "GuitarManufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
