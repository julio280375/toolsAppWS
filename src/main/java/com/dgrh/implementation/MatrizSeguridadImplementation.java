package com.dgrh.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.system.MatrizSeguridad;
import com.dgrh.repository.MatrizSeguridadRepository;
import com.dgrh.services.MatrizSeguridadService;


@Service
public class MatrizSeguridadImplementation implements MatrizSeguridadService{
	
	@Autowired
	private MatrizSeguridadRepository matrizSeguridadRepository;
	
	

	

	public MatrizSeguridad busca_perfil_proceso(Integer perfil, String proceso){
		return matrizSeguridadRepository.findByPerfilIdAndProcesoNombre(perfil, proceso);
				
	}



}
