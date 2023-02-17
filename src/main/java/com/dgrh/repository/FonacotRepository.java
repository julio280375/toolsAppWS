package com.dgrh.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgrh.objects.business.Fonacot;

public interface FonacotRepository extends JpaRepository<Fonacot, Integer> {
	
	Fonacot findByCredito(Integer credito);
	
	List<Fonacot> findAll();
	
	//void delete(Fonacot fonacot);
}
