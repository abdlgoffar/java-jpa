package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//contoh cara pembuatan parent entity dalam konsep joined table inheritance.
//untuk mengetahui cara pengisian data dan fetch data joined table inheritance lihat di package test class JoinedTableInheritanceTesting.
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column
    private Long amount;
}
