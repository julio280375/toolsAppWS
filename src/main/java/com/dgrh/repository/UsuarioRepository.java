package com.dgrh.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dgrh.objects.system.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByCuenta(String cuenta);
	
}
