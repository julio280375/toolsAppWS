package com.dgrh.objects.business;



import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dgrh.objects.system.Auditable;
import com.dgrh.objects.system.AuditableListener;


@Entity
@Table(name="movimiento")
@EntityListeners(AuditableListener.class)
public class Movimiento implements Auditable {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private Date fecha;
	private String cuenta;
	private String banco_cuenta;
	private Integer plazo;
	private Double importe;
	private Double tasa;
	private Double interes;
	private Double traspaso;
	private Double saldo_anterior;
	private Double descuento;
	private Double deposito;
	private Integer usuario_id;
	private Timestamp created;

	
	


	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}





	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public Double getTraspaso() {
		return traspaso;
	}

	public void setTraspaso(Double traspaso) {
		this.traspaso = traspaso;
	}

	public Double getSaldo_anterior() {
		return saldo_anterior;
	}

	public void setSaldo_anterior(Double saldo_anterior) {
		this.saldo_anterior = saldo_anterior;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDeposito() {
		return deposito;
	}

	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}

	public String getBanco_cuenta() {
		return banco_cuenta;
	}

	public void setBanco_cuenta(String banco_cuenta) {
		this.banco_cuenta = banco_cuenta;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	
	
	





	
	}
