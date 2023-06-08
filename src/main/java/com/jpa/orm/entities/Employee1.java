package com.jpa.orm.entities;

//contoh cara pembuatan parent entity dalam konsep single table inheritance.
//untuk mengetahui cara pengisian data dan fetch data single table inheritance lihat di package test class SingleTableInheritanceTesting.
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("EMPLOYEE1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee1 {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Getter @Setter
    @Column
    private String name;
}
