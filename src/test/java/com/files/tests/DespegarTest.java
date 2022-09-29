package com.files.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

@BeforeMethod(alwaysRun= true)
public void iniciarDriver(ITestContext context) {
	//obtener navegador
	String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
	String navegador = navegadorSuite!=null ? navegadorSuite:"CHROME" ;
	//URL
	String url ="https://www.despegar.com.ar";
	driver=Driver.AbrirBrowser(navegador, url);
	
}
@DataProvider(name="Destino")
public Object[][] DataProviderDestino(){
	return new Object[][] {{"España"},{"Italia"}};
}

@Test(dataProvider="Destino", description = "Validar la seccion alojamiento de la web Despegar.com")

public void ValidarWebDespegar(String lugar ) throws Exception {
	
	
	DespegarHomePage homePage= new DespegarHomePage(driver);
	
	//Seleccionar Boton Alojamiento
	AlojamientoPage alojamiento =homePage.clickAlojamiento();
	
	//Ingresar Destino
	alojamiento.ingresarDestino(lugar);
	
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
	
	//Validacion de Titulo Hotel	
	Assert.assertTrue(detalledelHotel.validarTituloHotel(),"No se encuentra el titulo");			
	System.out.println("Hotel Seleccionado "+ detalledelHotel.InfoHotel());
	
	
}
@Test(description = "Prueba Botones Menu")
public void ObtenerBotonesMenu() throws Exception {	
	
	DespegarHomePage homePage= new DespegarHomePage(driver);
	
	List<WebElement> lista=homePage.ListaBotones();
	
	for(WebElement boton:lista) {
		System.out.println(boton.getText());
	}
	
}

	@AfterMethod 
	public void cerrarDrive() {
		//Cerrar Browser
		Driver.CerrarBrowser(driver);
	}
}