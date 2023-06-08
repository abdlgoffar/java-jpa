package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


//contoh penerapan mapped super class pada entity.
//untuk melihat class entity lain yg extends ke entity ini lihat class Cart.
@MappedSuperclass
@EntityListeners(AuditableEntityListener.class)
public class AuditableEntity< T extends Serializable> implements AuditableEntityImpl {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private T id;


    @Column(name = "create_at")
    private LocalDateTime createAt;


    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Override
    public void setCreateAt(LocalDateTime localDateTime) {
        this.createAt = localDateTime;
    }

    @Override
    public void setUpdateAt(LocalDateTime localDateTime) {
        this.updateAt = localDateTime;
    }
}
