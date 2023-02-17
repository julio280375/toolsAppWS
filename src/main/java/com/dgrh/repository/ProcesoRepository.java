package com.dgrh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dgrh.objects.system.Proceso;


public interface ProcesoRepository extends JpaRepository<Proceso, Integer> {
	
	Proceso findByNombre(String nombre);
	
}
