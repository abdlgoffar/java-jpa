package com.jpa.orm;

import com.jpa.orm.entities.Employee;
import com.jpa.orm.entities.embedded.Name;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class FieldCollectionOrMapUpdate {
    @Test
    void update() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = entityManager.find(Employee.class, "32256843-d39b-4d69-b20a-ff262f7561c1");
            employee.setHobbies(new ArrayList<>());
            employee.getHobbies().add("play football");
            employee.getHobbies().add("watch movie");
            entityManager.merge(employee);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
