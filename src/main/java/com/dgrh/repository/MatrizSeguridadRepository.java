package com.dgrh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dgrh.objects.system.MatrizSeguridad;

public interface MatrizSeguridadRepository extends JpaRepository<MatrizSeguridad, Integer> {
	

	@Query(value="select ms.* from toolsapp.matriz_seguridad ms left join toolsapp.perfil per on per.id=ms.perfil_id left join toolsapp.proceso pro on pro.id=ms.proceso_id where per.id=:P1 and pro.nombre=:P2",nativeQuery = true)
	MatrizSeguridad findByPerfilIdAndProcesoNombre(@Param("P1") Integer p1, @Param("P2") String p2);
	
}

