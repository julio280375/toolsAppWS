package com.dgrh;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dgrh.objects.system.Bitacora;
import com.dgrh.objects.system.Configuracion;
import com.dgrh.objects.system.Header;
import com.dgrh.objects.system.MatrizSeguridad;
import com.dgrh.objects.system.Proceso;
import com.dgrh.objects.system.Usuario;
import com.dgrh.services.BitacoraService;
import com.dgrh.services.MatrizSeguridadService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@SuppressWarnings("deprecation")
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
	private static Logger LOG =  LoggerFactory.getLogger(RequestInterceptor.class);
	
	@Autowired
	private MatrizSeguridadService matrizSeguridadService;
	@Autowired
	private BitacoraService bitacoraService;	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Gson gSon= new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		Boolean respuesta=false;
		String[] uri= request.getRequestURI().split("/");
		String process=uri[uri.length-2]+"."+uri[uri.length-1];
		String xHeader=getHeaderValue(request, "xHeader");
		LOG.info("xHeader: "+xHeader);
		Header header = gSon.fromJson(xHeader, Header.class);	
		
		if((header.getEquipo()==null) && (process.equals("configuracion.filter")||process.equals("equipo.filter"))) {
			respuesta=true;
		}else {
		
			Configuracion configuracion=header.getConfiguracion().stream().filter(elem->elem.getConcepto().equals("TIPO_VALIDACION_PROCESO")).findFirst().orElse(null);
			if(configuracion==null) {
				respuesta=true;
			}else {
				if(configuracion.getValor().toUpperCase().equals("VALIDA_PROCESS")) {
					MatrizSeguridad matriz=matrizSeguridadService.busca_perfil_proceso(header.getUsuario().getPerfil_id(), process);
					if(matriz!=null) {			
						guardaBitacora(header.getUsuario(),matriz.getProceso());
						respuesta=true;
					}
				}else {
					respuesta=true;
				}
			}
			
		}
		LOG.info("****** Termina preHandle Result:["+respuesta.toString().toUpperCase()+"] ******");
		return respuesta;
	}


	private String getHeaderValue( HttpServletRequest request,String key ) {
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String pkey = (String) headerNames.nextElement();
			String value = request.getHeader(pkey);
			if (pkey.toUpperCase().equals(key.toUpperCase()))			
				return value;			
		} 
		return "";
	}

	private void guardaBitacora(Usuario usuario, Proceso proceso)
	{
		Bitacora bitacora=new Bitacora();		
		bitacora.setUsuario(usuario);
		bitacora.setProceso(proceso);
		bitacoraService.save(bitacora);
	}
	

}
