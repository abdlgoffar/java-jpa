package com.jpa.orm.entities;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditableEntityListener {
    @PrePersist
    @PostPersist
    public void setDataCreateTime(AuditableEntityImpl auditableEntity) {
        auditableEntity.setCreateAt(LocalDateTime.now());
        auditableEntity.setUpdateAt(LocalDateTime.now());
    }

    @PreUpdate
    @PostUpdate
    public void setDataUpdateTime(AuditableEntityImpl auditableEntity) {
        auditableEntity.setUpdateAt(LocalDateTime.now());
    }
}
