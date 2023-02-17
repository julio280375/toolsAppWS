package com.dgrh.objects.system;


import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="usuario")
@EntityListeners(AuditableListener.class)
public class Usuario implements Auditable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cuenta;
	private String password;
	private String nombre;
	private Integer perfil_id;
	private Timestamp created;

	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Integer getPerfil_id() {
		return perfil_id;
	}
	public void setPerfil_id(Integer perfil_id) {
		this.perfil_id = perfil_id;
	}
	
	
	
	}
