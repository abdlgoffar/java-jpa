package com.jpa.orm;

import com.jpa.orm.entities.Cart;
import com.jpa.orm.entities.Payment;
import com.jpa.orm.entities.PaymentCreditCard;
import com.jpa.orm.entities.PaymentOVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class AuditableEntityTesting {
    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Cart cart = new Cart();
            cart.setName("abdul goffar cart");
            entityManager.persist(cart);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void update() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Cart cart = entityManager.find(Cart.class, "f9327886-ee00-4d75-a70c-115e69195556");
            cart.setName("goffar cart");
            entityManager.merge(cart);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
