package com.dgrh.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.system.Proceso;
import com.dgrh.repository.ProcesoRepository;
import com.dgrh.services.ProcesoService;


@Service
public class ProcesoImplementation implements ProcesoService{
	
	@Autowired
	private  ProcesoRepository  procesoRepository;
	
	
	
	
	public Proceso busca_nombre(String nombre){
		return procesoRepository.findByNombre(nombre);
				
	}
	



}
