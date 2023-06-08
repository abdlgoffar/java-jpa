package com.jpa.orm;

import com.jpa.orm.entities.Director;
import com.jpa.orm.entities.Employee1;
import com.jpa.orm.entities.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SingleTableInheritanceTesting {
    @Test
    void create() {
        //dengan konsep single table inheritance maka data entity bisa ditambahkan
        //melalui parent dan child entity tersebut sesuai ketersediaan field pada entity itu, lihat seperti contoh di bawah.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //menambah data melalui parent entity.
            Employee1 employee1a = new Employee1();
            employee1a.setName("abdul fahmi");
            entityManager.persist(employee1a);
            //menambah data melalui child entity.
            Director director = new Director();
            director.setName("hisbul khofi");
            entityManager.persist(director);
            Manager manager = new Manager();
            manager.setName("ainun noval");
            manager.setNumberOfManager(530);
            entityManager.persist(manager);
            director.setNumberOfDirector(340);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    //dengan konsep single table inheritance find bisa langsung spesifik ke Child Entity, atau lewat Parent Entity.
    //jika melakukan Find menggunakan Parent Entity, dan ternyata data tersebut adalah Child Entity, kita bisa konversi obejct secara manual seperti object biasa.
    @Test
    void find() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //find melalui parent entity
            Employee1 employee1 = entityManager.find(Employee1.class, "9eb63d67-aafe-44c9-863f-39fae11bc771");
            log.info(employee1.getName());
            //find melalui child entity
            Manager manager = entityManager.find(Manager.class, "86e26416-9062-44d9-925e-677b8efc7e53");
            log.info(manager.getName());
            Director director = entityManager.find(Director.class, "a707082e-e41e-4790-aa3d-e28840983772");
            log.info(director.getName());
            //konversi object pada saat kesalahan find data
            Employee1 employee1b = entityManager.find(Employee1.class, "86e26416-9062-44d9-925e-677b8efc7e53");
            Manager manager1 = (Manager) employee1b;
            log.info(manager1.getName());
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
