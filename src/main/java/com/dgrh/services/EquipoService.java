package com.dgrh.services;

import com.dgrh.objects.system.Equipo;


public interface EquipoService {
	
	Equipo busca_mac(String mac);
	
	Equipo busca_ip(String ip);
	
	Equipo busca_nombre(String nombre);

}
