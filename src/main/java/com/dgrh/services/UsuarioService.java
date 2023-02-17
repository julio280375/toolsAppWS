package com.dgrh.services;

import com.dgrh.objects.system.Usuario;


public interface UsuarioService {
	
	Usuario save(Usuario usuario);
	
	void delete(Usuario usuario);
	
	Usuario busca_cuenta(String cuenta);

}
