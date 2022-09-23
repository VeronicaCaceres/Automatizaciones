package com.files.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.files.driver.Driver;
import Pages.DespegarHomePage;
import Pages.AlojamientoPage;
import Pages.AlojamientoHotelesPage;
import Pages.DetalleHotelPage;
public class DespegarTest {
WebDriver driver;

@Test(description = "Validar la seccion alojamiento de la web Despegar.com")
public void ValidarWebDespegar() throws Exception {
	String url ="https://www.despegar.com.ar";
	driver=Driver.AbrirBrowser("CHROME", url);
	
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
	
	//Cerrar Browser
	Driver.CerrarBrowser(driver);
}

}