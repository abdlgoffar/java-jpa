package com.jpa.orm.entities.listener.auditing;

import java.time.LocalDateTime;

public interface UpdatedAtAware {
     void setUpdatedAt(LocalDateTime localDateTime);//operasi yang ingin dilakukan method ini, dilakukan pada class entity listenernya.
}
