package com.jpa.orm;

import com.jpa.orm.entities.Product;
import com.jpa.orm.entities.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
@Slf4j
public class ManyToManyRelation {
    @Test
    void relation() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, "a75a0a1e-2734-4b6b-bef3-8f0201e3b65b");
            product.setSellers(new HashSet<>());
            product.getSellers().add(entityManager.find(Seller.class, "632ad037-abf3-43b4-8751-cf4ea27129cb"));
            product.getSellers().add(entityManager.find(Seller.class, "8ee72ae0-d94c-4e35-b9ef-c1368c3c0844"));
            product.getSellers().add(entityManager.find(Seller.class, "a86318ce-3520-4773-b5b2-82a5815bbe10"));
            entityManager.merge(product);
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
            Product productById = entityManager.find(Product.class, "a75a0a1e-2734-4b6b-bef3-8f0201e3b65b");
            transaction.commit();
            for (Seller seller : productById.getSellers()) {
                log.info(seller.getName());
            }
        }catch (Throwable throwable) {
            //transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
