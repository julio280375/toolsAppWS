package com.dgrh.services;

import java.util.Date;
import java.util.List;
import com.dgrh.objects.business.Socio;


public interface SocioService {
	
	List<Socio> saveAll(List<Socio> lista);
	
	List<Socio> listado();
	
	List<Socio> listado_codigo(String codigo);
	
	List<Socio> listado_codigo_like(String codigo);
	
	List<Socio> listado_nombre_like(String nombre);
	
	List<Socio> listado_codigo_nombre(String codigo, String nombre);
	
	List<Socio> listado_fecha_movimiento(Date fecha);
	
	List<Socio> listado_codigo_arreglo(List<Integer> codigos);
	
	List<Socio> listado_cuenta_like(String cuenta);
	
	List<Socio> listado_rendimiento();
}
