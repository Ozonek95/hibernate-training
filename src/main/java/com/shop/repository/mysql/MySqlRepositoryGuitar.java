package com.shop.repository.mysql;

import com.shop.domain.Guitar;
import org.hibernate.Session;

import java.util.List;

public class MySqlRepositoryGuitar {

    private Session session;

    public MySqlRepositoryGuitar(Session session) {
        this.session = session;
    }

    public Integer create(Guitar guitar){

        return (Integer) session.save(guitar);
    }


    public Guitar findById(int productId) {
        return session.get(Guitar.class,productId);
    }

    public void update(Guitar guitar) {
        session.update(guitar);
    }

    public void delete(Guitar guitar){
        session.delete(guitar);
    }

    public List<Guitar> findAll() {
       return session.createQuery("FROM Guitar").list();
    }
}
