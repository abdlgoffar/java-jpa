package com.jpa.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//contoh cara pembuatan child entity dalam konsep joined table inheritance.
//untuk mengetahui cara pengisian data dan fetch data joined table inheritance lihat di package test class JoinedTableInheritanceTesting.
@Entity
@Table(name = "payment_ovo")
public class PaymentOVO extends Payment{
    @Getter @Setter
    @Column(name = "ovo_id")
    private String ovoId;
}
