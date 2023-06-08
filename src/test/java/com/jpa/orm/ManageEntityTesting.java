package com.jpa.orm;
import com.jpa.orm.entities.Size;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;


public class ManageEntityTesting {
    //contoh penerapan managed entity
    @Test
    void manageEntityTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Size size = new Size();
            size.setNumber(100);
            entityManager.persist(size);//apabila object size disini sudah menjadi parameter object method interface entityManager.
            size.setNumber(300);//dan disini obejct size dilakukan perubahan data, maka meski perubahan object size dilakukan sesudah transaksi
            //entityManager.persist(size) maka data pada database akan ikut terubah.
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    //contoh penerapan untuk menghindari managed entity.
    @Test
    void unManageEntityTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            //untuk menghindari manage entity cukup menggunakan method detach(), namunmethod ini hanya bisa digunakan pada find() data saja.
            transaction.begin();
            Size size = entityManager.find(Size.class, "998d7e3e-045e-40a5-b542-90553347e482");
            entityManager.detach(size);//detach().
            size.setNumber(200000);//disini meski ada perubahan data entity, tapi data di database tidak akan terubah karena method detach().
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
