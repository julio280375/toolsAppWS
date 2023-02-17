package com.dgrh.services;



import java.util.Date;
import java.util.List;
import com.dgrh.objects.business.Movimiento;


public interface MovimientoService {
	
	public List<Movimiento> save(List<Movimiento> lista);
	
	public void delete(Movimiento movimiento);
	
	public void delete_fecha(Date fecha);
	
	public List<Movimiento> busca_fecha(Date fecha);
	
	public List<Movimiento> busca_fecha_between(Date fecha1, Date fecha2);

}
