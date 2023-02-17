package com.dgrh.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dgrh.objects.business.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer> {
	
	@Query(value="select * from toolsapp.socio where codigo = :p1", nativeQuery = true)
	List<Socio> listado_codigo(@Param("p1") String P1);
	
	@Query(value="select * from toolsapp.socio where codigo like %:p1%", nativeQuery = true)
	List<Socio> listado_codigo_like(@Param("p1") String P1);
	
	@Query(value="select * from toolsapp.socio where nombre like %:p1%", nativeQuery = true)
	List<Socio> listado_nombre_like(@Param("p1") String P1);
	
	@Query(value="select * from toolsapp.socio where codigo like %:p1% and nombre like %:p2%", nativeQuery = true)
	List<Socio> listado_codigo_nombre(@Param("p1") String P1, @Param("p2") String P2);
	
	//@Query(value="select s.* from toolsapp.socio s left join toolsapp.movimiento m on m.socio_codigo=s.codigo where m.fecha=cast(:p1 as date)", nativeQuery = true)
	@Query(value="select * from toolsapp.socio s where codigo in (select distinct(m.socio_codigo) from toolsapp.movimiento m where m.fecha=cast(:p1 as date))", nativeQuery = true)
	List<Socio> listado_fecha_movimiento(@Param("p1") Date p1);
	
	@Query(value="select * from toolsapp.socio s where s.codigo in (:codigos)",nativeQuery =true)
	List<Socio> listado_codigo_arreglo(@Param("codigos") List<Integer> codigos);
	
	@Query(value="select * from toolsapp.socio where cuenta like %:p1%", nativeQuery = true)
	List<Socio> listado_cuenta_like(@Param("p1") String P1);
	
	@Query(value="select * from toolsapp.socio where interes>0 order by codigo", nativeQuery = true)
	List<Socio> listado_rendimiento();
	
	
}
