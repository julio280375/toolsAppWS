package com.dgrh.objects.business;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dgrh.objects.system.Auditable;
import com.dgrh.objects.system.AuditableListener;




@Entity
@Table(name="cuentas_faby")
public class CuentasFaby  {
	@Id
	@Column(unique = true, nullable = false)
	private Integer codigo;
	private Double interes;
}
