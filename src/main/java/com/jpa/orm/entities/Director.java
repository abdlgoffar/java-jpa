package com.jpa.orm.entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

//contoh cara pembuatan child entity dalam konsep single table inheritance.
//untuk mengetahui cara pengisian data dan fetch data single table inheritance lihat di package test class SingleTableInheritanceTesting.
@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends Employee1 {
    @Getter @Setter
    @Column(name = "number_of_director")
    private Integer numberOfDirector;
}
