package com.jpa.orm.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

//cara pembuaatan class embedded
@Embeddable
public class Name {
    @Column(name = "title")
    private String title;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;

    public Name() {
    }

    public Name(String title, String firstName, String middleName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
//untuk mengetahui cara penggunaan class embedded lihat di package entities class Employee.
