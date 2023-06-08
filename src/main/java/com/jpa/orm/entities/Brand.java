package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Brand {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Getter @Setter
    @Column
    private String name;

    @Getter @Setter
    @Column
    private String description;

    @Getter @Setter
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
    public Brand() {
    }

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
