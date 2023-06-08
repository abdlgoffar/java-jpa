package com.jpa.orm.entities;

import com.jpa.orm.entities.listener.auditing.UpdatedAtAware;
import com.jpa.orm.entities.listener.auditing.UpdatedAtListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Calendar;
//contoh cara pembuatan entity listener, entity nya diberi annotation @EntityListeners dengan property class entity listenernya
//dan implement pada interface dimana pada interface itu terdapat sebuah method yang akan dilakukan modifikasi.
@ToString
@Entity
@EntityListeners(
        UpdatedAtListener.class
)
public class Category implements UpdatedAtAware {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)//apabila type data yg digunakan adalah java.util disarankan diberi annotation @Temporal
    private Calendar createAt;


    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    public Category() {
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    //untuk mengetahui cara pengisian data type date time lihat di package test class DateTimeTesting.
    //untuk mengetahui hasil dari entity listener lihat di package test class EntityListenerTest.
}
