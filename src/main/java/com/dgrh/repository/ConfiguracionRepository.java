package com.dgrh.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgrh.objects.system.Configuracion;



public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {
	
	Configuracion findByConcepto(String concepto);
	
	List<Configuracion> findAll();
	
}
