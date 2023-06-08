package com.jpa.orm;

import com.jpa.orm.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@Slf4j
public class CrudTesting {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();;
    @Test
    void createDataTest() {
        try {
            transaction.begin();
            Product product = new Product();
            product.setId("4c1d515d-b03e-4f2f-8d80-e84714339b7a");
            product.setName("new vario 160");
            entityManager.persist(product);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void findDataTest() {
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, "4c1d515d-b03e-4f2f-8d80-e84714339b6e");
            transaction.commit();
            log.info(product.toString());
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void updateDataTest() {
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, "4c1d515d-b03e-4f2f-8d80-e84714339b6e");
            product.setName("new cbr 250 r");
            entityManager.merge(product);
            transaction.commit();
            log.info(product.toString());
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void deleteDataTest() {
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, "4c1d515d-b03e-4f2f-8d80-e84714339b6e");
            entityManager.remove(product);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
