package com.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory entitymManagerFactory;

    static {
        entitymManagerFactory = Persistence.createEntityManagerFactory("ProgettoS9");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entitymManagerFactory;

    }
}