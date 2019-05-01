package modelo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConsultarFecha {
	
	private String formatoISO8601 = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
	private String formatoLatinoamericano = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
	private String formatoNorteamericano = "([0-9]{2})-([0-9]{2})-([0-9]{4})";
	
	public Date convertirFecha(String fechaEnTexto) {
		SimpleDateFormat formato = compararFecha(fechaEnTexto);
		Date fecha = null;
		
		try {
			fecha = formato.parse(fechaEnTexto);
		} 		
		catch (ParseException e) {
			System.out.println(e);
		}
		return fecha;
	}
	
	private SimpleDateFormat compararFecha(String fechaEnTexto) {
        SimpleDateFormat formatoDeFecha = null;

        if (fechaEnTexto.matches(formatoISO8601)) {
            formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        } 
        else if (fechaEnTexto.matches(formatoLatinoamericano)) {
            formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        } 
        else if (fechaEnTexto.matches(formatoNorteamericano)) {
            formatoDeFecha = new SimpleDateFormat("MM-dd-yyyy");
        }
        
        return formatoDeFecha;
    }
}