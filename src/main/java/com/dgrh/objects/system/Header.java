package com.dgrh.objects.system;

import java.util.List;

public class Header {
	private String sesionID;
	private Equipo equipo;
	private Usuario usuario;
	private List<Configuracion> configuracion;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSesionID() {
		return sesionID;
	}
	public void setSesionID(String sesionID) {
		this.sesionID = sesionID;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public List<Configuracion> getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(List<Configuracion> configuracion) {
		this.configuracion = configuracion;
	}

}
