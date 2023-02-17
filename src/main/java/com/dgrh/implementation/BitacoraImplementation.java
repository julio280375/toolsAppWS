package com.dgrh.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.system.Bitacora;
import com.dgrh.repository.BitacoraRepository;
import com.dgrh.services.BitacoraService;


@Service
public class BitacoraImplementation implements BitacoraService{
	
	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	
	public Bitacora save(Bitacora  bitacora) {

		return bitacoraRepository.save(bitacora);

	}
	
	



}
