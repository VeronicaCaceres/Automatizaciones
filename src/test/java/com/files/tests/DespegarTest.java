package com.files.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.driver.Driver;
import Pages.DespegarHomePage;
import Pages.AlojamientoPage;
import Pages.AlojamientoHotelesPage;
import Pages.DetalleHotelPage;
public class DespegarTest {
WebDriver driver;

@BeforeMethod
public void iniciarDriver(ITestContext context) {
	//obtener navegador
	String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
	String navegador = navegadorSuite!=null ? navegadorSuite:"EDGE" ;
	//URL
	String url ="https://www.despegar.com.ar";
	driver=Driver.AbrirBrowser(navegador, url);
	
}



@Test(description = "Validar la seccion alojamiento de la web Despegar.com")

public void ValidarWebDespegar() throws Exception {
	
	
	DespegarHomePage homePage= new DespegarHomePage(driver);
	
	//Seleccionar Boton Alojamiento
	AlojamientoPage alojamiento =homePage.clickAlojamiento();
	
	//Ingresar Destino
	alojamiento.ingresarDestino("España");
	
	//Seleccionar fecha
	alojamiento.clickCalendario();
	
	//Ingresar fecha Entrada
	alojamiento.clickFechaEntrada();
	
	//Ingresar fecha Salida
	alojamiento.clickFechaSalida();
	
	//Aplicar Fecha
	alojamiento.clickBotonAplicarFecha();
	
	//Seleccionar Habitación
	alojamiento.clickHabitacion();

    //Ingresar cantidad de Adultos
	alojamiento.AgregarAdulto();
	
	//Ingresar cantidad de Menores
	alojamiento.AgregarMenores();
	
	//Abrir combo menores
	alojamiento.ComboMenores();
	
	//Seleccionar Edad del menor
	alojamiento.AgregarEdad();
	
	//Seleccionar Boton Habitaciones
	alojamiento.clickBotonAplicarHabitacion();
	
	//Seleccionar Boton Buscar
	alojamiento.clickBotonBuscar();
	
	//Seleccionar Boton Detalle
	AlojamientoHotelesPage alojamientoHotel= alojamiento.clickBotonBuscar();
			
	//Ver informacion de Hotel
	DetalleHotelPage detalledelHotel= alojamientoHotel.ClickBotonDetalles();
	
	// Detalle del Hotel
	detalledelHotel.InfoHotel();
	
	
	
}

	@AfterMethod 
	public void cerrarDrive() {
		//Cerrar Browser
		Driver.CerrarBrowser(driver);
	}
}