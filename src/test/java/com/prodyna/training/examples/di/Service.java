package com.prodyna.training.examples.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {

    private Dao dao;

    public Service(@Autowired Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
