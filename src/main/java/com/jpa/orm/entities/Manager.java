package com.jpa.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

//contoh cara pembuatan child entity dalam konsep single table inheritance.
//untuk mengetahui cara pengisian data dan fetch data single table inheritance lihat di package test class SingleTableInheritanceTesting.
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee1 {
    @Getter @Setter
    @Column(name = "number_of_manager")
    private Integer numberOfManager;
}

