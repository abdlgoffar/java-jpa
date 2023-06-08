package com.jpa.orm;

import com.jpa.orm.entities.Credential;
import com.jpa.orm.entities.User;
import com.jpa.orm.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class OneToOneRelationForeignKey {
    @Test
    void relation() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, "000000");
            Wallet wallet = new Wallet(2_000_000L, user);
            entityManager.persist(wallet);
            transaction.commit();
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
            Wallet walletById = entityManager.find(Wallet.class, "ecf1995f-cffc-4209-a6e7-9b358c1a5cf4");
            transaction.commit();
            log.info(walletById.getUser().getName());
        }catch (Throwable throwable) {
            //transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
