
package com.dgrh.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgrh.objects.system.Body;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.objects.system.Usuario;
import com.dgrh.services.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;






@RestController    
@RequestMapping(path="toolsAppWS/usuario") 
public class UsuarioController {
	private static Logger LOG =  LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/save",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  save(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO UsuariosController.save ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			Usuario  usuario = usuarioService.save(body.getUsuario());
			if(usuario!=null) {
				resp.setCode(200);
				resp.setMessage(HttpStatus.OK.toString());
				body.setUsuario(usuario);
				resp.setData(gSon.toJson(body));	
			}else {
				LOG.info("Error al agregar el registro [usuario/save]");
				resp.setCode(104);
				resp.setMessage(Errores.error(104));			
			}
			
		}catch(Exception exc){				
			//Error inesperado
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);							
	}
	
	
	@RequestMapping(method=RequestMethod.POST, path="/delete",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  delete(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO UsuariosController.delete ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			try {
				usuarioService.delete(body.getUsuario());
				resp.setCode(200);
				resp.setMessage(HttpStatus.OK.toString());
			}catch(Exception exc){
				LOG.info("Error al eliminar el registro [usuario/delete]");
				resp.setCode(104);
				resp.setMessage(Errores.error(104));			
			}
			
		}catch(Exception exc){				
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);							
	}
	

	

	@RequestMapping(method=RequestMethod.POST, path="/filter",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  filter(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO UsuariosController.filter");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		Usuario usuario=new Usuario();
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {

				case "BY_CUENTA": 
					usuario = usuarioService.busca_cuenta(body.getFilterValONE());
				break;
			}
			resp.setCode(200);
			resp.setMessage("OK");			
			resp.setData(gSon.toJson(usuario));
					
		}catch(Exception exc){								
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);			
		
		
	}
	
	

	
	
	
	
 }