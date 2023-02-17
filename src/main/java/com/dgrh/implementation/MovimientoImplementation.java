package com.dgrh.implementation;



import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dgrh.objects.business.Movimiento;
import com.dgrh.repository.MovimientoRepository;
import com.dgrh.services.MovimientoService;

@Service
public class MovimientoImplementation implements MovimientoService{
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	
	public List<Movimiento>  save(List<Movimiento> lista) {
		return movimientoRepository.saveAll(lista);
	}
	
	
	public void  delete(Movimiento movimiento) {
		movimientoRepository.delete(movimiento);
	}
	
	
	public void  delete_fecha(Date fecha) {
		movimientoRepository.deleteByFecha(fecha);
	}
	
	public List<Movimiento> busca_fecha(Date fecha){
		return movimientoRepository.findByFecha(fecha);	
	}
	
	public List<Movimiento> busca_fecha_between(Date fecha1, Date fecha2){
		return movimientoRepository.findByBetweenFecha(fecha1, fecha2);			
	}

}
