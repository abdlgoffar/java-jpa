package com.jpa.orm;

import com.jpa.orm.entities.Department;
import com.jpa.orm.entities.embedded.DepartmentId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class FieldEmbeddedIdTesting {
    @Test
    void fieldEmbeddedIdCreateTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        UUID uuid = UUID.randomUUID();
        try {
            transaction.begin();
            Department department = new Department(new DepartmentId(uuid.toString(), uuid.toString()), "pt. berkah rizky");
            entityManager.persist(department);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
