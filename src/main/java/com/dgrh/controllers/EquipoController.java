
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
import com.dgrh.objects.system.Equipo;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.services.EquipoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;






@RestController    
@RequestMapping(path="toolsAppWS/equipo") 
public class EquipoController {
	private static Logger LOG =  LoggerFactory.getLogger(EquipoController.class);
	
	@Autowired
	private EquipoService equipoService;
	

	
	
	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/filter",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  filter(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO EquipoController.filter");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		Equipo equipo = new Equipo();
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {
				case "VALIDA MAC":equipo=equipoService.busca_mac(body.getFilterValONE());					
					break;
				case "VALIDA_IP":equipo=equipoService.busca_ip(body.getFilterValONE());
					break;
				case "VALIDA_NOMBREPC":equipo=equipoService.busca_nombre(body.getFilterValONE());
					break;
				}
			resp.setCode(200);
			resp.setMessage("OK");			
			resp.setData(gSon.toJson(equipo));
					
		}catch(Exception exc){								
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);			
		
		
	}
	
	

	
	
	
	
 }