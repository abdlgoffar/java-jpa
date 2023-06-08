package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class User {
    @Id
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column(name = "name", nullable = false)
    private String name;

    //contoh relasi table dengan data primary key yang sama, sebetulnya cara ini melakukan konsep join query.
    //namun cara ini jarang dilakukan karena data yang ingin berelasi harus mempunyai id yang sama.
    //untuk mengetahui cara pengisian data relasi table dengan data primary key yang sama lihat di package test class OneToOneRelationSamePrimaryKey.
    @Getter @Setter
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private Credential credential;


    @OneToOne(mappedBy = "user")
    private Wallet wallet;

    @OneToMany(mappedBy = "user")
    private List<Sale> sales;
    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
