package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.AlojamientoPage;


public class DespegarHomePage {
	@FindBy(xpath ="//a[@title='Alojamientos']")
	private WebElement buttonAlojamiento;
	
	@FindBy(xpath="//a[@title='Vuelos']")
	private WebElement buttonVuelos;
	
	private WebDriver driver=null;
	private WebDriverWait wait=null;
	
	public DespegarHomePage(WebDriver driver) {
		this.driver=driver;		
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
				
		
		PageFactory.initElements(driver, this);
	}
    public AlojamientoPage clickAlojamiento() {
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonAlojamiento));
		buttonAlojamiento.click();
		
		return new AlojamientoPage(this.driver);
				
	}
	
}