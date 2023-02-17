package com.dgrh.objects.system;

import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Errores implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public static ResponseEntity<String> errorResponse(Integer codigo, String mensaje, HttpStatus status){
		ResponseEntity<String> response;
		ResponseWS resp = new ResponseWS();
		Gson gSon= new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		String jsonResponse;

		resp.setCode(codigo);
		resp.setMessage(mensaje);
		jsonResponse = gSon.toJson(resp);
		response=new ResponseEntity<>(jsonResponse, status);
		return response;
	}
	
	
	public static String error(int noError){		
		if(noError == 0) return "OK";
				
		//*ERRORES GENERALES*//				
		if(noError == 400) return HttpStatus.BAD_REQUEST.toString();
		if(noError == 500) return HttpStatus.INTERNAL_SERVER_ERROR.toString();
		
		
		//*ERRORES PERSONALIZADOS*//		
		if(noError == 101) return "EQUIPO NO REGISTRADO EN EL SISTEMA.";
		if(noError == 102) return "USUARIO NO REGISTRADO EN EL SISTEMA.";
		if(noError == 103) return "USUARIO Y/O PASSWORD INCORRECTOS.";
		if(noError == 104) return "NÚMERO DOCUMENTO DE CLIENTE NO ENCONTRADO.";
		if(noError == 105) return "ERROR AL BORRAR EL REGISTRO";
		
		return "ERROR NO DEFINIDO";
	}
	
	
}
