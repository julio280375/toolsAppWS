package com.dgrh.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.system.Equipo;
import com.dgrh.repository.EquipoRepository;
import com.dgrh.services.EquipoService;


@Service
public class EquipoImplementation implements EquipoService{
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	
	public Equipo save(Equipo  equipo) {

		return equipoRepository.save(equipo);

	}
	
	
	
	
	public Equipo busca_mac(String mac){
		return equipoRepository.findByMac(mac);
				
	}
	
	public Equipo busca_ip(String ip){
		return equipoRepository.findByIp(ip);
				
	}
	
	public Equipo busca_nombre(String nombre){
		return equipoRepository.findByNombre(nombre);
				
	}


}
