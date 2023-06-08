package com.jpa.orm;

import com.jpa.orm.entities.Category;
import com.jpa.orm.entities.Employee;
import com.jpa.orm.entities.embedded.Name;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class FieldEmbeddedTesting {
    @Test
    void fieldEmbeddedCreateTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = new Employee(
                    new Name("Man", "abdul", "goffar", "supriyadi"),
                    "jl. jaksa agung suprapto");
            entityManager.persist(employee);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
