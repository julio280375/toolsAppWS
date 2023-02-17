
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
import com.dgrh.objects.business.Movimiento;
import com.dgrh.objects.system.Body;
import com.dgrh.objects.system.Errores;
import com.dgrh.objects.system.Respuesta;
import com.dgrh.services.MovimientoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;






@RestController    
@RequestMapping(path="toolsAppWS/movimientos") 
public class MovimientoController {
	private static Logger LOG =  LoggerFactory.getLogger(MovimientoController.class);
	
	@Autowired
	private MovimientoService movimientoService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/save",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  save(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO MovimientoController.save ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			if(body.getListaMovimientos()==null)  {
				resp.setCode(400);
				resp.setMessage(Errores.error(400));			
			}else {
				List<Movimiento> lista = movimientoService.save(body.getListaMovimientos());
				if(lista!=null) {
					resp.setCode(200);
					resp.setMessage(HttpStatus.OK.toString());
					body.setListaMovimientos(lista);
					resp.setData(gSon.toJson(body));	
				}else {
					LOG.info("Error al agregar el registro [movimientos/save]");
					resp.setCode(104);
					resp.setMessage(Errores.error(104));			
				}
			}
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
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO MovimientoController.filter");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		List<Movimiento> lista=new ArrayList<>();
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			
			switch (body.getFilter().toUpperCase()) {
				case "BY_FECHA_BETWEEN": 
					Date fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse(body.getFilterValONE());  
					Date fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse(body.getFilterValTWO());
					try	{
						
						lista = movimientoService.busca_fecha_between(fecha1, fecha2);

					}catch(Exception exc){	
						LOG.info("Registro no encontrado [dispersion/filter]");
						LOG.error(exc.getMessage());							
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
	
	
	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, path="/delete",consumes = "application/json", produces = "application/json")	
	public ResponseEntity<String>  delete(@Context HttpServletRequest request, @RequestBody final String reqbody) {
		LOG.info("**************** ENTRO AL METODO POST DEL SERVICIO MovimientoController.delete ****************");
		Respuesta resp = new Respuesta();
		String jsonResponse;			
		Gson gSon = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();			
		try
		{								
			Body body = gSon.fromJson(reqbody, Body.class);
			switch (body.getFilter().toUpperCase()) {
			case "BY_FECHA_MOVIMIENTO": 
				Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(body.getFilterValONE());  
				try	{
					
					movimientoService.delete_fecha(fecha);
					
					resp.setCode(200);
					resp.setMessage("OK");	

				}catch(Exception exc){	
					LOG.error(exc.getMessage());
					LOG.info("Error al borrar el registro [movimiento/delete]");
					resp.setCode(105);
					resp.setMessage(Errores.error(105));
				}	
			break;
		}
		}catch(Exception exc){				
			LOG.error(exc.getMessage());			
			return Errores.errorResponse(500, Errores.error(500), HttpStatus.INTERNAL_SERVER_ERROR);				
		}			
		jsonResponse =gSon.toJson(resp);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);							
	}
	

	
	
	
	
 }