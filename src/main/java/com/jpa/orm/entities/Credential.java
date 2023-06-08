package com.jpa.orm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Credential {
    @Id
    @Column(nullable = false)
    private String id;

    @Getter @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "credential")
    private User user;
    public Credential() {
    }

    public Credential(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;

    }
}
