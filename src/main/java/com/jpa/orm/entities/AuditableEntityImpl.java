package com.jpa.orm.entities;

import java.time.LocalDateTime;

public interface AuditableEntityImpl {
    void setCreateAt(LocalDateTime localDateTime);
    void setUpdateAt(LocalDateTime localDateTime);
}
