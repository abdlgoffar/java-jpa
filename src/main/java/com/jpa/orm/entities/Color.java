package com.jpa.orm.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//contoh cara pembuatan table dengan looking optimistic, dimana hanya perlu menambahkan field/column penanda dengan annotation @Version
//yang bertype data Long atau Timestamp.
//untuk mengetahui cara pengetesan multiple transaksi lihat di package test class LookingOptimisticTesting.
@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;


    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Version
    private Long version;
}
