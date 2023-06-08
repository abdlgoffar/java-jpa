package com.jpa.orm;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class EntityManagerFactoryTesting {
    @Test
    void entityManagerTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        entityManagerFactory.close();
    }
}
