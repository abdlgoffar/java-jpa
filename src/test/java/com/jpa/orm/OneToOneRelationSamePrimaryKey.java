package com.jpa.orm;

import com.jpa.orm.entities.Credential;
import com.jpa.orm.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class OneToOneRelationSamePrimaryKey {
    @Test
    void relation() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User("000000", "hamzah");
            entityManager.persist(user);
            Credential credential = new Credential("000000", "hamzah@gmail.com", "hamzah123");
            entityManager.persist(credential);
            User userById = entityManager.find(User.class, "000000");
            transaction.commit();
            log.info(userById.toString());
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void find() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User userById = entityManager.find(User.class, "000000");
            transaction.commit();
            log.info(userById.toString());
            log.info(userById.getCredential().getEmail());
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
