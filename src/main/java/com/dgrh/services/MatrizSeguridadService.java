package com.dgrh.services;

import com.dgrh.objects.system.MatrizSeguridad;


public interface MatrizSeguridadService {
		
	MatrizSeguridad busca_perfil_proceso(Integer perfil, String proceso);
	
}
