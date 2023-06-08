package com.jpa.orm.entities.listener.auditing;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdatedAtListener {
    @PrePersist
    @PreUpdate
    public void setLastUpdateAt(UpdatedAtAware updatedAtAware) {
        updatedAtAware.setUpdatedAt(LocalDateTime.now());
    }
}
