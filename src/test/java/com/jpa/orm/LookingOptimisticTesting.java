package com.jpa.orm;

import com.jpa.orm.entities.Cart;
import com.jpa.orm.entities.Color;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class LookingOptimisticTesting {
    //disini terdapat dua transaksi UPDATE data database yang akan berjalan secara bersamaan, diamana transaksi pertama akan di sleep atau diperlambat
    //selama 20 detik dan transaksi kedua akan normal seperti biasa, jadi dengan konsep looking optimistic seharusnya transaksi pertama akan di failed/rollback
    //oleh database.
    @Test
    void transactionDatabase1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        Color color = entityManager.find(Color.class, "d6cadb69-4db9-4253-a59b-7461af2c144c");
        color.setName("red update 1");
        Thread.sleep(20 * 1000L);
        entityManager.persist(color);
        transaction.commit();


        entityManager.close();
        entityManagerFactory.close();
    }
    @Test
    void transactionDatabase2() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        Color color = entityManager.find(Color.class, "d6cadb69-4db9-4253-a59b-7461af2c144c");
        color.setName("red update 2");
        entityManager.persist(color);
        transaction.commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
