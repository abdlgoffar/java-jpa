package com.jpa.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//contoh cara pembuatan child entity dalam konsep joined table inheritance.
//untuk mengetahui cara pengisian data dan fetch data joined table inheritance lihat di package test class JoinedTableInheritanceTesting.
@Entity
@Table(name = "payment_credit_card")
public class PaymentCreditCard extends Payment{
    @Getter @Setter
    @Column(name = "masked_card")
    private String masked_card;

    @Getter @Setter
    @Column(name = "bank")
    private String bank;
}
