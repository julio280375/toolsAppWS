
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

import com.dgrh.objects.business.Fonacot;
import com.dgrh.objects.system.Body;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.services.FonacotService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;






@RestController    
@RequestMapping(path="toolsAppWS/fonacot") 
public class FonacotController {
	private static Logger LOG =  LoggerFactory.getLogger(FonacotController.class);
	
	@Autowired
	private FonacotService fonacotService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/save",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  save(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO FonacotController.save ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			List<Fonacot> listaFonacot = fonacotService.saveAll(body.getListaFonacot());
			if(listaFonacot!=null) {
				resp.setCode(200);
				resp.setMessage(HttpStatus.OK.toString());
				body.setListaFonacot(listaFonacot);
				resp.setData(gSon.toJson(body));	
			}else {
				LOG.info("Error al agregar el registro [fonacot/save]");
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
	
	
	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/delete",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  delete(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO FonacotController.delete ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			Fonacot fonacot = body.getListaFonacot().get(0);
			fonacotService.delete(fonacot);

			resp.setCode(200);
			resp.setMessage(HttpStatus.OK.toString());	

			
		}catch(Exception exc){				
			//Error inesperado
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);							
	}
	

	

	@RequestMapping(method=RequestMethod.POST, path="/filter",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  filter(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO FonacotController.filter");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		List<Fonacot> lista=new ArrayList<>();
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {
				case "ALL":lista=fonacotService.listado();				
				break;
				case "BY_CREDITO_LIKE": 
					Fonacot fonacot = fonacotService.busca_credito(Integer.valueOf(body.getFilterValONE()));
					if(fonacot!=null) {
						lista.add(fonacot);
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