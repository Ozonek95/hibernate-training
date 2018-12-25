package com.shop.repository.mysql;

import com.shop.domain.Guitar;
import org.hibernate.Session;

public class MySqlRepositoryGuitar {

    private Session session;

    public MySqlRepositoryGuitar(Session session) {
        this.session = session;
    }

    public Integer create(Guitar guitar){

        return (Integer) session.save(guitar);
    }


}
