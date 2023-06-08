package com.jpa.orm;

import com.jpa.orm.entities.Employee;
import com.jpa.orm.entities.embedded.Name;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FieldCollectionTesting {
    @Test
    void createFieldCollectionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = new Employee(
                    new Name("Man", "ainun", "noval", "musni"),
                    "jl. jaksa agung suprapto");
            //pengisian data collection field
            employee.setHobbies(new ArrayList<>());
            employee.getHobbies().add("play football");
            employee.getHobbies().add("watch football");
            entityManager.persist(employee);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
