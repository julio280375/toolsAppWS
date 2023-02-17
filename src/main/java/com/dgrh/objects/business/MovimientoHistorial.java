package com.dgrh.objects.business;



import java.sql.Date;


public class MovimientoHistorial  {

	
	
	private Date fecha;
	private Integer contador;
	private String tipo;
	private Double deposito;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getDeposito() {
		return deposito;
	}
	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}
	
	}
