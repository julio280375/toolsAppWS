package com.dgrh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dgrh.objects.system.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
	
	Equipo findByMac(String mac);
	
	Equipo findByIp(String ip);
	
	Equipo findByNombre(String nombre);
	
}
