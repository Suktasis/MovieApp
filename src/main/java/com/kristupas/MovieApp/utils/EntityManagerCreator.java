package com.kristupas.MovieApp.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static final String PERSISTENCE_UNIT = "persistence";

    EntityManagerFactory entityManagerFactory = null;


    public EntityManagerFactory getFactory(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            return entityManagerFactory;
        }
        return entityManagerFactory;
    }

    private void test(){
        EntityManager em = getFactory().createEntityManager();
    }
}
