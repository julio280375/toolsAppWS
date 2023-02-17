package com.dgrh.services;

import java.util.List;

import com.dgrh.objects.business.Fonacot;



public interface FonacotService {
	
	List<Fonacot> saveAll(List<Fonacot> listaFonacot);
	
	void delete(Fonacot fonacot);
	
	Fonacot busca_credito(Integer credito);

	List<Fonacot> listado();
}
