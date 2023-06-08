package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Supplier {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Column
    @Lob //untuk field data type clob atau blob direkomendasikan diberi annotation @Lob
    private String description;

    @Getter @Setter
    @Column
    @Lob //untuk field data type clob atau blob direkomendasikan diberi annotation @Lob
    private byte[] image;
}
