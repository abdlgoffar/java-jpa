package com.jpa.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class TransactionTesting {
    //pada transaction jpa ada tiga perintah penting yang pertama  begin() yang artinya mulai transaksi,
    //kedua commit() apabila ingin menyimpan hasil transaksi, dan ketiga rollback() apabila ingin menggagalkan atau membatalkan transaksi.
    @Test
    void transactionTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //TRANSACTION
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
