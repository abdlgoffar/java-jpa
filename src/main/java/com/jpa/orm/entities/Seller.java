package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
        @NamedQuery(name = "Seller.findById", query = "SELECT s FROM Seller s WHERE s.id = :id")})
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column
    private String name;

    @ManyToMany(mappedBy = "sellers")
    private Set<Product> products;
    public Seller() {
    }

    public Seller(String name) {
        this.name = name;
    }
}
