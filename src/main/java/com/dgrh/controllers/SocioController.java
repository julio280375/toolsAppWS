
package com.dgrh.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.dgrh.objects.business.Socio;
import com.dgrh.objects.system.Body;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.ResponseWS;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.services.SocioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;







@RestController    
@RequestMapping(path="toolsAppWS/socios") 
public class SocioController {
	private static Logger LOG =  LoggerFactory.getLogger(SocioController.class);
	
	@Autowired
	private SocioService socioService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/save",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<ResponseWS>  save(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO SocioController.save ****************");
		ResponseWS resp = new ResponseWS();		
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			if(body.getListaSocios()==null)  {
				resp.setCode(400);
				resp.setMessage(Errores.error(400));			
			}else {					
				List<Socio> listaSocios = socioService.saveAll(body.getListaSocios());
				if(listaSocios!=null) {
					resp.setCode(200);
					resp.setMessage(HttpStatus.OK.toString());
					body.setListaSocios(listaSocios);
					resp.setData(gSon.toJson(body));	
				}else {
					LOG.info("Error al agregar el registro [socio/save]");
					resp.setCode(104);
					resp.setMessage(Errores.error(104));			
				}
			}
		}catch(Exception exc){				
			LOG.error(exc.getMessage());			
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		return new ResponseEntity<>(resp, HttpStatus.OK);							
	}
	

	@RequestMapping(method=RequestMethod.POST, path="/filter",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  filter(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO SocioController.filter");
		Respuesta resp = new Respuesta();
		//esponseWS resp = new ResponseWS();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		List<Socio> lista=new ArrayList<>();
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {
				case "ALL":lista = socioService.listado();
				break;
				case "BY_CODIGO":
					lista = socioService.listado_codigo(body.getFilterValONE());
				break;
				case "BY_CODIGO_LIKE":
					lista = socioService.listado_codigo_like(body.getFilterValONE());
				break;
				case "BY_NOMBRE_LIKE":lista = socioService.listado_nombre_like(body.getFilterValONE());
				break;
				case "BY_CODIGO_NOMBRE":lista = socioService.listado_codigo_nombre(body.getFilterValONE(), body.getFilterValTWO());
				break;			
				case "BY_FECHA_MOVIMIENTO":
					Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(body.getFilterValONE()); 
					lista = socioService.listado_fecha_movimiento(fecha);
				break;
				case "BODY_CODIGO_ARRAY":lista = socioService.listado_codigo_arreglo(body.getListaInteger());
				break;
				case "BY_CUENTA_LIKE":
					lista = socioService.listado_cuenta_like(body.getFilterValONE());
				break;
				case "BY_RENDIMIENTO":
					lista = socioService.listado_rendimiento();
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
