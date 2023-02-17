package com.dgrh.objects.business;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import com.dgrh.objects.system.Auditable;
import com.dgrh.objects.system.AuditableListener;




@Entity
@Table(name="fonacot")
@EntityListeners(AuditableListener.class)
public class Fonacot implements Auditable {
	@Id
	@Column(unique = true, nullable = false)
	private Integer credito;
	private Integer codigo;
	private String nombre;
	private String fonacot;
	private String estatus;
	private String adscripcion;
	private Timestamp created;
	
	
	public Integer getCredito() {
		return credito;
	}
	public void setCredito(Integer credito) {
		this.credito = credito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFonacot() {
		return fonacot;
	}
	public void setFonacot(String fonacot) {
		this.fonacot = fonacot;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getAdscripcion() {
		return adscripcion;
	}
	public void setAdscripcion(String adscripcion) {
		this.adscripcion = adscripcion;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	}
