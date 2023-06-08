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

public class FieldMapTesting {
    @Test
    void createFieldMapTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = new Employee(
                    new Name("Man", "rizal", "maulana", "supaidi"),
                    "jl. jaksa agung suprapto");
            employee.setHobbies(new ArrayList<>());
            employee.getHobbies().add("play playstation");
            employee.getHobbies().add("watch basketball");
            //pengisian data map field
            employee.setSkills(new HashMap<>());
            employee.getSkills().put("php", 86);
            employee.getSkills().put("laravel", 75);
            employee.getSkills().put("javascript", 75);
            employee.getSkills().put("react", 69);
            employee.getSkills().put("java", 89);
            employee.getSkills().put("spring boot", 86);
            entityManager.persist(employee);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
