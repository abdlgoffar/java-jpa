package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    //contoh cara mengubah fetch type EAGER pada relationship entity menjadi LAZY.
    //artinya jika fetch type sudah diubah dari EAGER ke LAZY maka query SELECT data
    //pada entity tidak akan join lagi meski entity tersebut punya relasi dengan entity lain.
    //cara mengetahui hasil perubahan dari fetch type lihat di package test class FetchTesting.
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Sale() {
    }

    public Sale( User user) {
        this.user = user;
    }
}
