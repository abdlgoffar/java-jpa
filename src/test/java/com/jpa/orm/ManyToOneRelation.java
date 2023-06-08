package com.jpa.orm;

import com.jpa.orm.entities.Brand;
import com.jpa.orm.entities.Product;
import com.jpa.orm.entities.User;
import com.jpa.orm.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class ManyToOneRelation {
    @Test
    void relation() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Brand brand = new Brand("SAMSUNG", "cellphone");
            entityManager.persist(brand);
            Product product = new Product("samsung a 50", brand);
            entityManager.persist(product);
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
            Product productById = entityManager.find(Product.class, "e561c21d-e197-4604-8dcb-ceac121c506e");
            transaction.commit();
            log.info(productById.getBrand().getName());
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
