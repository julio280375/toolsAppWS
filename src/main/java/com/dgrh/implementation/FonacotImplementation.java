package com.dgrh.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.business.Fonacot;
import com.dgrh.repository.FonacotRepository;
import com.dgrh.services.FonacotService;


@Service
public class FonacotImplementation implements FonacotService{
	
	@Autowired
	private FonacotRepository fonacotRepository;
	
	
	public List<Fonacot> saveAll(List<Fonacot>  listaFonacot) {

		return fonacotRepository.saveAll(listaFonacot);

	}
	
	
	public void delete(Fonacot fonacot) {
		fonacotRepository.delete(fonacot);
		
	}

	
	
	public Fonacot busca_credito(Integer credito){
		return fonacotRepository.findByCredito(credito);
				
	}
	
	
	
	public List<Fonacot> listado() {

		return fonacotRepository.findAll();

	}


}
