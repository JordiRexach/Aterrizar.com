package modelo;

import java.util.Calendar;
import java.util.Date;
import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class ConsultarFechaTest {
	
	@Test
	public void convertirFecha_LaFechaEnFormatoISO8601SeConvierteEnDate(){
		Date fecha = ConsultarFecha.convertirFecha("2019-04-30");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato ISO8601 no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}
	
	@Test
	public void convertirFecha_LaFechaEnFormatoLatinoamericanoSeConvierteEnDate(){
		Date fecha = ConsultarFecha.convertirFecha("30/04/2019");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato Latinoamericano no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}
	
	@Test
	public void convertirFecha_LaFechaEnFormatoNorteamericanoSeConvierteEnDate(){
		Date fecha = ConsultarFecha.convertirFecha("04-30-2019");
		
		Calendar resultadoEsperado = Calendar.getInstance();
        resultadoEsperado.clear();
        resultadoEsperado.set(2019, Calendar.APRIL, 30);
        
		Assert.assertTrue("La fecha en formato Norteamericano no se a convertido a formato Date", resultadoEsperado.getTime().equals(fecha));
	}
	
	@Test
	public void calcularDiferenciaEntreDosFechas_LasFechasTienenUnDiaDeDiferencia() {
		Date fecha1 = ConsultarFecha.convertirFecha("30/04/2019");
		Date fecha2 = ConsultarFecha.convertirFecha("29/04/2019");		

		Assert.assertTrue("Las fechas no tienen un dia de diferencia", ConsultarFecha.calcularDiferenciaEntreDosFechas(fecha1, fecha2) == 1);
	}

	@Test
	public void calcularDiferenciaEntreDosFechas_LasFechasTienenDosDiasDeDiferencia() {
		Date fecha1 = ConsultarFecha.convertirFecha("28/04/2019");
		Date fecha2 = ConsultarFecha.convertirFecha("30/04/2019");		

		Assert.assertTrue("Las fechas no tienen dos dias de diferencia", ConsultarFecha.calcularDiferenciaEntreDosFechas(fecha1, fecha2) == 2);
	}

	@Test
	public void calcularDiferenciaEntreDosFechas_LasFechasTienenTresDiasDeDiferencia() {
		Date fecha1 = ConsultarFecha.convertirFecha("30/04/2019");
		Date fecha2 = ConsultarFecha.convertirFecha("03/05/2019");		

		Assert.assertTrue("Las fechas no tienen tres dias de diferencia", ConsultarFecha.calcularDiferenciaEntreDosFechas(fecha1, fecha2) == 3);
	}

	@Test
	public void esAnterior_miFechaDeNacimientoEsAnteriorALaDeMiHermano() {
		Date miFechaDeNacimiento = ConsultarFecha.convertirFecha("25/04/1996");
		Date fechaDeNacimientoDeMiHermano = ConsultarFecha.convertirFecha("04/05/2000");		

		Assert.assertTrue("Mi fecha de nacimiento no es anterior a la de mi hermano", ConsultarFecha.esAnterior(miFechaDeNacimiento, fechaDeNacimientoDeMiHermano));

	}

	@Test
	public void esAnterior_ElEstrenoDeMarsAttacksNoEsAnteriorAMiFechaDeNacimiento() {
		Date miFechaDeNacimiento = ConsultarFecha.convertirFecha("25/04/1996");
		Date fechaDeEstrenoDeMarsAttacks = ConsultarFecha.convertirFecha("12/12/1996");		

		Assert.assertFalse("Mi fecha de nacimiento es anterior al estreno de Mars Attacks!", ConsultarFecha.esAnterior(fechaDeEstrenoDeMarsAttacks, miFechaDeNacimiento));

	}
}
