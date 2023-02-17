package com.dgrh.objects.system;

import java.util.List;

import com.dgrh.objects.business.Fonacot;
import com.dgrh.objects.business.Movimiento;
import com.dgrh.objects.business.Socio;

public class Body {
	private String filter;
	private String filterValONE;
	private String filterValTWO;
	private Usuario usuario;
	private Equipo equipo;
	private List<Fonacot> listaFonacot;
	private List<Socio> listaSocios;
	private List<Movimiento> listaMovimientos;
	private List<Integer> listaInteger;
	private List<Configuracion> listaConfiguracion;
	
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public List<Socio> getListaSocios() {
		return listaSocios;
	}
	public void setListaSocios(List<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}
	public List<Movimiento> getListaMovimientos() {
		return listaMovimientos;
	}
	public void setListaMovimientos(List<Movimiento> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}
	public String getFilterValTWO() {
		return filterValTWO;
	}
	public void setFilterValTWO(String filterValTWO) {
		this.filterValTWO = filterValTWO;
	}
	public String getFilterValONE() {
		return filterValONE;
	}
	public void setFilterValONE(String filterValONE) {
		this.filterValONE = filterValONE;
	}
	public List<Integer> getListaInteger() {
		return listaInteger;
	}
	public void setListaInteger(List<Integer> listaInteger) {
		this.listaInteger = listaInteger;
	}
	public List<Configuracion> getListaConfiguracion() {
		return listaConfiguracion;
	}
	public void setListaConfiguracion(List<Configuracion> listaConfiguracion) {
		this.listaConfiguracion = listaConfiguracion;
	}
	public List<Fonacot> getListaFonacot() {
		return listaFonacot;
	}
	public void setListaFonacot(List<Fonacot> listaFonacot) {
		this.listaFonacot = listaFonacot;
	}



}
