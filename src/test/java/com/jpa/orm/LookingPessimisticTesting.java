package com.jpa.orm;

import com.jpa.orm.entities.Color;
import com.jpa.orm.entities.Size;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

public class LookingPessimisticTesting {
    //untuk membuat looking pessimistic cukup menambahkan 1 parameter lagi LockModeType.PESSIMISTIC_WRITE saat find data yang ingin di UPDATE.
    //disini terdapat dua transaksi database secara bersamaan dimana transaksi pertama akan dilakukan setelah 20 detik, denga konsep
    //looking pessimistic itu artinya transaksi kedua akan menunggu atau mengantri selama 20 detik.
    //bayangin jika tidak melakukan konsep ini maka transaksi yang lebih cepat akan di eksekusi dahulu oleh database, bukan transaksi yg terlebih dahulu,
    //berarti nantinya transaksi kedua yang akan di eksekusi dahulu bukan transaksi pertama meski lebih dahulu melakukan transaksi ke database.
    @Test
    void transactionDatabase1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Size size = entityManager.find(Size.class, "998d7e3e-045e-40a5-b542-90553347e482", LockModeType.PESSIMISTIC_WRITE);
        size.setNumber(40);
        Thread.sleep(20 * 1000L);
        entityManager.persist(size);

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

        Size size = entityManager.find(Size.class, "998d7e3e-045e-40a5-b542-90553347e482", LockModeType.PESSIMISTIC_WRITE);
        size.setNumber(45);
        entityManager.persist(size);
        transaction.commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
