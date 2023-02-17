package com.dgrh.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.system.Usuario;
import com.dgrh.repository.UsuarioRepository;
import com.dgrh.services.UsuarioService;


@Service
public class UsuarioImplementation implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario save(Usuario  usuario) {

		return usuarioRepository.save(usuario);

	}
	
	
	public void  delete(Usuario  usuario) {
		
		usuarioRepository.delete(usuario);
		
	}
	
	
	public Usuario busca_cuenta(String cuenta){
		return usuarioRepository.findByCuenta(cuenta);
				
	}
	



}
