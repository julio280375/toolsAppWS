
package com.dgrh.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.dgrh.objects.system.Configuracion;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.ResponseWS;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.services.ConfiguracionService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;






@RestController    
@RequestMapping(path="toolsAppWS/configuracion") 
public class ConfiguracionController {
	private static Logger LOG =  LoggerFactory.getLogger(ConfiguracionController.class);
	
	@Autowired
	private ConfiguracionService configuracionService;
	

	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/save",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<ResponseWS>  save(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO ConfiguracionService.save ****************");
		ResponseWS resp = new ResponseWS();			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			if(body.getListaConfiguracion() == null)  {
				resp.setCode(400);
				resp.setMessage(Errores.error(400));			
			}else {					
				configuracionService.saveAll(body.getListaConfiguracion());
				resp.setCode(200);
				resp.setMessage(HttpStatus.OK.toString());
			}
		}catch(Exception exc){				
			LOG.error(exc.getMessage());			
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);						
		}			
		return new ResponseEntity<>(resp, HttpStatus.OK);							
	}
	
	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/filter",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  filter(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO ConfiguracionController.filter");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		List<Configuracion> lista=new ArrayList<>();
		Configuracion configuracion;
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {
				case "ALL":lista=configuracionService.listado();				
					break;
				case "CONCEPTO":configuracion=configuracionService.busca_concepto(body.getFilterValONE());
					if(configuracion!=null) {
						lista.add(configuracion);
					}
					break;
			}
			resp.setCode(200);
			resp.setMessage("OK");			
			resp.setData(gSon.toJson(lista));
					
		}catch(Exception exc){								
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);			
		
		
	}
	
	

	
	
	
	
 }