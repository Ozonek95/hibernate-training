package com.shop.controller;

import com.shop.domain.*;
import com.shop.repository.mysql.MySqlRepositoryGuitar;
import org.hibernate.Session;

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
//
    }



