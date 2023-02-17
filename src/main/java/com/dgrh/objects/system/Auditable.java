package com.dgrh.objects.system;


import java.sql.Timestamp;

public interface Auditable {

	Timestamp getCreated();
    
    void setCreated(Timestamp created);   

   
}