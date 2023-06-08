package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    private Long balance;

    //contoh relasi table dengan dengan data foreign key.
    //untuk mengetahui cara pengisian data relassi table one to one dengan foreign key lihat di package test class OneToOneRelationForeignKey.
    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Wallet() {
    }

    public Wallet(Long balance, User user) {
        this.balance = balance;
        this.user = user;
    }
}
