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
@Table(name="socio")
@EntityListeners(AuditableListener.class)
public class Socio implements Auditable {
	@Id
	@Column(unique = true, nullable = false)
	private Integer codigo;
	//private Integer id;
	private String nombre;

	private String cuenta;
	private String banco_cuenta;
	private Double ahorro;
	private Double interes;
	private Boolean reinversion;
	private Boolean generar_cheque;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "socio_codigo",nullable=false)
	private List<Movimiento> movimientos=new ArrayList<>();
	private Timestamp created;
	
	
	
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getBanco_cuenta() {
		return banco_cuenta;
	}
	public void setBanco_cuenta(String banco_cuenta) {
		this.banco_cuenta = banco_cuenta;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public Double getAhorro() {
		return ahorro;
	}
	public void setAhorro(Double ahorro) {
		this.ahorro = ahorro;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		this.interes = interes;
	}
	public Boolean getReinversion() {
		return reinversion;
	}
	public void setReinversion(Boolean reinversion) {
		this.reinversion = reinversion;
	}
	public Boolean getGenerar_cheque() {
		return generar_cheque;
	}
	public void setGenerar_cheque(Boolean generar_cheque) {
		this.generar_cheque = generar_cheque;
	}

	
	
	
	

	
	
	}
