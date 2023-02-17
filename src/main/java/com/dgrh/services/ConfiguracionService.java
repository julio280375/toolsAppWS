package com.dgrh.services;

import java.util.List;

import com.dgrh.objects.system.Configuracion;



public interface ConfiguracionService {
	
	void saveAll(List<Configuracion> lista);
	
	Configuracion busca_concepto(String concepto);
	
	List<Configuracion> listado();

}
