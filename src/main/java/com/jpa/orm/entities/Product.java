package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Entity
public class Product {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;
    @Getter @Setter
    @Column
    private String name;

    //contoh cara pembuatan relation table many to one atau one to many.
    //untuk mrngrtahui cara pengisian data relation table many to one atau one to many lihat di package test class ManyToOneRelation.
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    //contoh cara pembuatan relation table many to many.
    //annotation @JoinTable digunakan untuk join query sekaligus pembuatan table tambahan sebagai tempat menyimpan foreign key kedua table resource.
    //untuk mengetahui cara pengisian data relation table many to many lihat di package test class ManyToManyRelation.
    @Getter @Setter
    @OneToMany
    @JoinTable(
            name = "product_seller",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "seller_id", referencedColumnName = "id"))
    private Set<Seller> sellers;
    public Product() {
    }

    public Product(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }
}
