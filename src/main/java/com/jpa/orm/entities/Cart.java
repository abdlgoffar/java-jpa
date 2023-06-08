package com.jpa.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//disini terdapat contoh class Cart yang extends ke class AuditableEntity yg artinya semua field class AuditableEntity
//juga dimiliki atau diturunkan ke class Cart.
//untuk mengetahui cara pengisian data class Cart lihat di package test class AuditableEntityTesting.
@Entity
@Table(name = "cart")
public class Cart extends AuditableEntity<String> {
    @Getter @Setter
    @Column
    private String name;
}
