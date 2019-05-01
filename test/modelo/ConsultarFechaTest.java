package modelo;

import java.util.Calendar;
import java.util.Date;
import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class ConsultarFechaTest {
	
	@Test
	public void convertirFecha_LaFechaEnFormatoISO8601SeConvierteEnDate(){
		ConsultarFecha textoFecha = new ConsultarFecha();
		Date fecha = textoFecha.convertirFecha("2019-04-30");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato ISO8601 no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}
	
	@Test
	public void convertirFecha_LaFechaEnFormatoLatinoamericanoSeConvierteEnDate(){
		ConsultarFecha textoFecha = new ConsultarFecha();
		Date fecha = textoFecha.convertirFecha("30/04/2019");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato Latinoamericano no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}
	
	@Test
	public void convertirFecha_LaFechaEnFormatoNorteamericanoSeConvierteEnDate(){
		ConsultarFecha textoFecha = new ConsultarFecha();
		Date fecha = textoFecha.convertirFecha("04-30-2019");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato Norteamericano no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}

}
