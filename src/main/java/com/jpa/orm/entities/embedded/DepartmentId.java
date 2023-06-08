package com.jpa.orm.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DepartmentId implements Serializable {
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "company_id")
    private String companyId;

    public DepartmentId() {
    }

    public DepartmentId(String departmentId, String companyId) {
        this.departmentId = departmentId;
        this.companyId = companyId;
    }
}
