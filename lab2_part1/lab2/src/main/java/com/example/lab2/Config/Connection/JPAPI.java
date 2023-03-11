package com.example.lab2.Config.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAPI {
    private static final String persistenceName = "com.application.design";
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    public static void close() {
        entityManagerFactory.close();
    }
}
