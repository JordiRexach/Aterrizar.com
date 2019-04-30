package modelo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConsultarFecha {
	
	public Date convertirISO8601AFecha(String ISO8601) {
		SimpleDateFormat formatoISO8601 = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		
		try {
			fecha = formatoISO8601.parse(ISO8601);
		} 		
		catch (ParseException e) {
			System.out.println(e);
		}
		return fecha;
	}
}