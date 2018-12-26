package com.shop.controller;

import com.shop.domain.*;
import com.shop.repository.mysql.MySqlRepositoryGuitar;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ControllerGuitar {
    private final Session session;
    private final MySqlRepositoryGuitar repositoryGuitar;

    public ControllerGuitar(Session session, MySqlRepositoryGuitar repositoryGuitar) {
        this.session = session;
        this.repositoryGuitar = repositoryGuitar;
    }

    public Integer createGuitar(Guitar guitar){
        Integer id = null;
        try {
            session.getTransaction().begin();
            guitar.getGuitarManufacturer().getGuitars().add(guitar);
            id = repositoryGuitar.create(guitar);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }

    public Guitar find(int productId){
        return repositoryGuitar.findById(productId);
    }

    public void updateManufacturer(GuitarManufacturer manufacturer, int guitarId){
        Guitar guitar = find(guitarId);
        guitar.setGuitarManufacturer(manufacturer);
        try {
            session.getTransaction().begin();
            repositoryGuitar.update(guitar);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void updatePrice(Price price,int guitarId){
        Guitar guitar = find(guitarId);
        guitar.setPrice(price);
        try {
            session.getTransaction().begin();
            repositoryGuitar.update(guitar);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void deleteGuitar(int guitarId){
        Guitar guitar = find(guitarId);
        try {
            session.getTransaction().begin();
            repositoryGuitar.delete(find(guitarId));
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<Guitar> findByPrice(double min, double max){
        Query query= session.createQuery("from Guitar g where g.price.value > ? and g.price.value < ? ORDER BY g.price.value");
        query.setParameter(0,min);
        query.setParameter(1,max);
        return query.getResultList();
    }

    public List<Guitar> findAll(){
       return repositoryGuitar.findAll();
    }
//
    }



