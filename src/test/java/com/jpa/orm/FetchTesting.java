package com.jpa.orm;

import com.jpa.orm.entities.Sale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FetchTesting {
    //lihat hasil jpa query di cmd saat runn test, untuk mengetahui hasil query SELECT agar membuktikan fetch type yang dimaksud.mv
    @Test
    void fetchTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Sale sale = entityManager.find(Sale.class, "0ba7a010-7cce-48f4-a672-5593b912b28b");
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
