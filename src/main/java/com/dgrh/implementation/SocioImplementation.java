package com.dgrh.implementation;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.business.Socio;
import com.dgrh.repository.SocioRepository;
import com.dgrh.services.SocioService;

@Service
public class SocioImplementation implements SocioService{
	
	@Autowired
	private SocioRepository socioRepository;
	
	public List<Socio>saveAll(List<Socio> lista){
		return socioRepository.saveAll(lista);
	}
	
	public Socio save(Socio  socio) {
		return socioRepository.save(socio);
	}
	
	public List<Socio> listado(){
		return socioRepository.findAll();
	}
	
	
	public List<Socio> listado_codigo(String codigo){
		return socioRepository.listado_codigo(codigo);
	}
	
	
	public List<Socio> listado_codigo_like(String codigo){
		return socioRepository.listado_codigo_like(codigo);
	}
	
	public List<Socio> listado_nombre_like(String nombre){
		return socioRepository.listado_nombre_like(nombre);
	}
	
	public List<Socio> listado_codigo_nombre(String codigo, String nombre){
		return socioRepository.listado_codigo_nombre(codigo, nombre);
	}
	
	public List<Socio> listado_fecha_movimiento(Date fecha){
		return socioRepository.listado_fecha_movimiento(fecha);
	}
	
	public List<Socio> listado_codigo_arreglo(List<Integer> codigos){
		return socioRepository.listado_codigo_arreglo(codigos);
	}

	public List<Socio> listado_cuenta_like(String cuenta){
		return socioRepository.listado_cuenta_like(cuenta);
	}
	
	public List<Socio> listado_rendimiento(){
		return socioRepository.listado_rendimiento();
	}
}
