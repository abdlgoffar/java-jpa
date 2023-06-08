package com.jpa.orm.entities;

import com.jpa.orm.entities.embedded.Name;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    //contoh cara penggunaan class embedded.
    @Embedded
    @Column(nullable = false)
    private Name name;
    @Getter @Setter
    @Column(nullable = false)
    private String address;

    //contoh cara pembuatan  collection field.
    @Getter @Setter
    @ElementCollection
    @CollectionTable(name = "hobby", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    @Column(name = "name")
    private List<String> hobbies;

    //contoh cara pembuatan map field.
    @Getter @Setter
    @ElementCollection
    @CollectionTable(name = "skill", joinColumns = @JoinColumn(
            name = "employee_id", referencedColumnName = "id"
    ))
    @MapKeyColumn(name = "name_or_key")
    @Column(name = "value")
    private Map<String, Integer> skills;
    public Employee() {
    }

    public Employee(Name name, String address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Name name, String address, List<String> hobbies) {
        this.name = name;
        this.address = address;
        this.hobbies = hobbies;
    }
}
//untuk mengetahui cara pengisian data class embedded lihat di package test class FieldEmbeddedTesting.
//untuk mnegetahui cara pengisian collection field data lihat di package test class FieldCollectionTesting.
//untuk mnegetahui cara pengisian map field data lihat di package test class FieldMapTesting.
