package com.jpa.orm;


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
public class JoinedTableInheritanceTesting {
    //dengan konsep joined table inheritance maka data entity bisa ditambahkan data
    //melalui child entity nya sesuai ketersediaan field pada entity itu, lihat seperti contoh di bawah.
    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            PaymentCreditCard paymentCreditCard = new PaymentCreditCard();
            paymentCreditCard.setMasked_card("1223-3432-7673");
            paymentCreditCard.setAmount(4_000_000L);
            paymentCreditCard.setBank("BRI");
            entityManager.persist(paymentCreditCard);
            PaymentOVO paymentOVO = new PaymentOVO();
            paymentOVO.setOvoId("120977235");
            paymentOVO.setAmount(1_000_000L);
            entityManager.persist(paymentOVO);
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    //dengan konsep joined table inheritance find bisa langsung spesifik ke Child Entity nya.
    //jika melakukan Find menggunakan Parent Entity, dan ternyata data tersebut adalah Child Entity, kita bisa konversi obejct secara manual seperti object biasa.
    @Test
    void find() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LEARNING");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //find melalui child entity
            PaymentOVO paymentOVO = entityManager.find(PaymentOVO.class, "a052cdc0-739d-458b-bf04-e7cd6d60b9c8");
            log.info("ovo id " + paymentOVO.getOvoId());
            //konversi object pada saat kesalahan find data
            Payment payment = entityManager.find(Payment.class, "a052cdc0-739d-458b-bf04-e7cd6d60b9c8");
            PaymentOVO paymentOVO1 = (PaymentOVO) payment;
            log.info("ovo id " + paymentOVO1.getOvoId());
            transaction.commit();
        }catch (Throwable throwable) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
