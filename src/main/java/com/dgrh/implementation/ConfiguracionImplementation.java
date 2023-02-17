package com.dgrh.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgrh.objects.system.Configuracion;
import com.dgrh.repository.ConfiguracionRepository;
import com.dgrh.services.ConfiguracionService;

@Service
public class ConfiguracionImplementation implements ConfiguracionService{
	
	@Autowired
	private  ConfiguracionRepository  configuracionRepository;
	
	
	public void saveAll(List<Configuracion>  configuracion) {
		configuracionRepository.saveAll(configuracion);
	}
	
	
	public Configuracion busca_concepto(String concepto){
		return configuracionRepository.findByConcepto(concepto);
			
	}
	
	
	public List<Configuracion> listado(){
		return configuracionRepository.findAll();
			
	}
	



}
