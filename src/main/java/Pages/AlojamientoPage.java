package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.AlojamientoHotelesPage;

public class AlojamientoPage {

	@FindBy(xpath ="//h1[text()='Alojamientos']")
	private WebElement tituloAlojamientos;

	@FindBy(css= "input[placeholder=\"Ingresá una ciudad, alojamiento o punto de interés\"]")
	private WebElement Destino;

	@FindBy (css= "input[placeholder=Entrada]")
	private WebElement calendario;

	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@data-month='2022-09']//*[text()='29']")
	private WebElement fechaEntrada;

	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@data-month='2022-09']//*[text()='30']")
	private WebElement fechaSalida;

	@FindBy(xpath="//button[@class='sbox5-3-btn -primary -md']")
	private WebElement buttonAplicarFecha;

	@FindBy(css="input.sbox5-3-second-input")
	private WebElement habitaciones;

	@FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div:nth-child(1).stepper__room__row button.steppers-icon-right.stepper__icon")
	private WebElement agregarAdulto;

	@FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div:nth-child(2).stepper__room__row button.steppers-icon-right.stepper__icon")
	private WebElement agregarMenor;

	@FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__room__row div.sbox5-select.-md")
	private WebElement comboMenores;

	@FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__room__row div.sbox5-select.-md option:nth-child(6)")
	private WebElement edad;

	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__footer ']//em[text()='Aplicar']")
	private WebElement buttonAplicarHabitacion;

	@FindBy(css="button.sbox5-box-button-ovr.sbox5-3-btn.sbox5-button.-secondary.-icon.-lg")
	private WebElement buttonBuscar;

	private WebDriver driver=null;
	private WebDriverWait wait=null;

	public AlojamientoPage(WebDriver driver) {
	this.driver=driver;
	this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			

	PageFactory.initElements(driver, this);
	}

	public void ingresarDestino(String text) throws Exception {
	wait.until(ExpectedConditions.elementToBeClickable(Destino));
	Destino.click();
	   Destino.sendKeys(text);
	Thread.sleep(3000);
	Destino.sendKeys(Keys.CONTROL);
	Thread.sleep(2000);
	Destino.sendKeys(Keys.ENTER);
	}


	public void clickCalendario() {
		wait.until(ExpectedConditions.elementToBeClickable(calendario));
		calendario.click();
	}

	public void clickFechaEntrada() {
		wait.until(ExpectedConditions.elementToBeClickable(fechaEntrada));
		fechaEntrada.click();
	}

	public void clickFechaSalida()throws Exception {
		wait.until(ExpectedConditions.visibilityOf(fechaSalida));
		wait.until(ExpectedConditions.elementToBeClickable(fechaSalida));
		fechaSalida.click();
	}

	public void clickBotonAplicarFecha(){
		wait.until(ExpectedConditions.elementToBeClickable(buttonAplicarFecha));
		buttonAplicarFecha.click();
	}

	public void clickHabitacion() {
		wait.until(ExpectedConditions.elementToBeClickable(habitaciones));
		habitaciones.click();
	}

    public void AgregarAdulto(){
    	wait.until(ExpectedConditions.elementToBeClickable(agregarAdulto));
    	agregarAdulto.click();	
    }
	public void AgregarMenores() {
		wait.until(ExpectedConditions.elementToBeClickable(agregarMenor));
		agregarMenor.click();	
	}
	public void ComboMenores() {
		wait.until(ExpectedConditions.elementToBeClickable(comboMenores));
		comboMenores.click();
	}
	public void AgregarEdad() {
		wait.until(ExpectedConditions.elementToBeClickable(edad));
		edad.click();
	}
	public void clickBotonAplicarHabitacion() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonAplicarHabitacion));
		buttonAplicarHabitacion.click();
	}
	public AlojamientoHotelesPage clickBotonBuscar() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonBuscar));
		buttonBuscar.click();
		
		return new AlojamientoHotelesPage(this.driver);		

				
	}
}
