 
package com.dgrh.objects.system;
 

import javax.ws.rs.core.Response;

public class ResponseWS {
	/**************************************************
	 * 
	 *                   ATTRIBUTES
	 * 
	 **************************************************/
	int code;
	String message;
	Object data;
	 /**************************************************
	 * 
	 *                   GETTER & SETTER
	 * 
	 **************************************************/
 

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public Response setResponse(int responseValue, Object entity)
	{
		 
	    return Response
	            .status(responseValue)
	            .entity(entity)
	            .build();
	}
}
