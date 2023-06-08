package com.jpa.orm;

import com.jpa.orm.entities.Brand;
import com.jpa.orm.entities.Employee;
import com.jpa.orm.entities.Product;

import com.jpa.orm.entities.Seller;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class QueryTesting {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    /**
     * saat ingin melakukan select semua data cukup melakukan query sepert contoh di bawah.
     * di jpa target query data bukan lagi table melainkan class entity.
     */
    @Test
    void selectAllQuery() {
        try {
            transaction.begin();
            TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b", Brand.class);
            List<Brand> result = query.getResultList();
            for (Brand brand : result) {
                System.out.println(brand.getId());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * saat ingin melakukan select data tertentu dengan where clause ukup melakukan query sepert contoh di bawah.
     */
    @Test
    void selectQueryWithWhereClause() {
        try {
            transaction.begin();
            TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name.firstName = :firstName and e.name.middleName = :middleName", Employee.class);
            query.setParameter("firstName", "abdul");
            query.setParameter("middleName", "goffar");
            List<Employee> result= query.getResultList();
            for (Employee employee : result) {
                System.out.println(employee.getAddress());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * saat ingin melakukan select data ke beberapa table sekaligus dengan join column cukup melakukan query sepert contoh di bawah.
     * join column cukup dilakukan ke field yang mererelasikan entity tersebut.
     */
    @Test
    void selectWithJoin() {
        try {
            transaction.begin();
            TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p JOIN p.brand b WHERE b.name = :brand", Product.class);
            query.setParameter("brand", "SAMSUNG");
            List<Product> result = query.getResultList();
            for (Product product : result) {
                System.out.println(product.getName());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * select join fetch digunakan untuk mengambil data field relation tanpa harus melakukan join query secara manual, biasanya ini digunakan ke relation many to many field.
     * target query join fetch adalah field yang mererelasikan entity tersebut, lihat seperti contoh dibawah.
     */
    @Test
    void selectJoinFetch() {
        try {
            transaction.begin();
            TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p JOIN FETCH p.sellers s WHERE s.name = :seller", Product.class);
            query.setParameter("seller", "samsung official surabaya");
            List<Product> result = query.getResultList();
            for (Product product : result) {
                System.out.println(product.getName());
                for (Seller seller : product.getSellers()) {
                    System.out.println(seller.getName());
                }
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * select with order adalah cara untuk melakukan select data sekaligus melakukan sorting berdasarkan DESCENDING ataupun ASCENDING.
     * untuk melakukan select dan sorting data lihat seperti contoh di bawah.
     */
    @Test
    void selectWithOrder() {
        try {
            transaction.begin();
            TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p ORDER BY p.name DESC", Product.class);
            List<Product> result = query.getResultList();
            for (Product product : result) {
                System.out.println(product.getName());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * select with limit digunakan untuk melakukan select data dengan dengan jumlah tertentu dan offset/dimulai dari data keberapa di urutan data tersebut.
     * untuk membuat select with limit lihat contoh di bawah.
     */
    @Test
    void selectWithLimit() {
        try {
            transaction.begin();
            TypedQuery<Seller> query = entityManager.createQuery("SELECT s FROM Seller s", Seller.class);
            query.setFirstResult(2);//method yang digunakan untuk menentukan data akan diambil dari urutan keberapa.
            query.setMaxResults(2);//method yang digunakan untuk menentukan jumlah data yang akan diambil.
            List<Seller> result = query.getResultList();
            for (Seller seller : result) {
                System.out.println(seller.getName());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * named query adalah cara melakukan query langsung di entity class untuk melakukan SELECT data.
     * untuk melihat cara pembuatan named query lihat di package entities class Seller disana terdapat annotation @NamedQueries().
     * dan untuk menggunakan named query tersebut cukup panggil sesuai nama yang diberikan, seperti contoh dibawah.
     */
    @Test
    void namedQuery() {
        try {
            transaction.begin();
            TypedQuery<Seller> query1 = entityManager.createNamedQuery("Seller.findById", Seller.class);
            query1.setParameter("id", "632ad037-abf3-43b4-8751-cf4ea27129cb");
            List<Seller> findById = query1.getResultList();
            for (Seller seller : findById) {
                System.out.println("find By id: " + seller.getName());
            }
            //////////////////////////////
            TypedQuery<Seller> query2 = entityManager.createNamedQuery("Seller.findAll", Seller.class);
            for (Seller seller : query2.getResultList()) {
                System.out.println("find all " + seller.getName());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * select some field digunakan untuk melakukan select data berdasarkan field tertentu, syaratnya field tersebut sudah dijadikan parameter constructor.
     * cara membuat select some field lihat seperti contoh di bawah.
     */
    @Test
    void selectSomeField() {
        try {
            transaction.begin();
            TypedQuery<Seller> query = entityManager.createQuery("SELECT new com.jpa.orm.entities.Seller(s.name) FROM Seller s", Seller.class);
            List<Seller> result = query.getResultList();
            for (Seller seller : result) {
                System.out.println(seller.getName());
            }
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
