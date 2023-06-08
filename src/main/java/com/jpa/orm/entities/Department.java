package com.jpa.orm.entities;

import com.jpa.orm.entities.embedded.DepartmentId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Department {
    //contoh pembuatan mutiple id pada sebuah class entity atau embedded id.
    @EmbeddedId
    private DepartmentId id;
    private String name;

    public Department() {
    }

    public Department(DepartmentId id, String name) {
        this.id = id;
        this.name = name;
    }
    //untuk mengetahui cara pengisian data embedded id lihat di package test class FieldEmbeddedIdTesting.

}
