package com.dgrh.repository;




import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dgrh.objects.business.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
	
	@Query(value="select * from toolsapp.movimiento m where m.fecha = cast(':p1' as date)", nativeQuery = true)
	List<Movimiento> findByFecha(@Param("p1") Date fecha);

	@Modifying
	@Transactional
	@Query(value="delete from toolsapp.movimiento m where m.fecha = cast(:p1 as date)", nativeQuery = true)
	void deleteByFecha(@Param("p1") Date fecha);
	
	@Query(value="select * from toolsapp.movimiento where fecha between cast(:p1 as date) and cast(:p2 as date)", nativeQuery = true)
	List<Movimiento> findByBetweenFecha(@Param("p1") Date fecha1, @Param("p2") Date fecha2);
	 
	
	
}
