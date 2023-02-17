package com.dgrh.objects.system;

import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.time.Instant;


public class AuditableListener {
    @PrePersist
    void preCreate(Auditable auditable) {
        Timestamp now = Timestamp.from(Instant.now());
        auditable.setCreated(now);
       
    }


}