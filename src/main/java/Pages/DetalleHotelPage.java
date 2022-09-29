package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DetalleHotelPage {
	@FindBy(css=".main-info h1.accommodation-name.eva-3-h2")
	private WebElement TituloHotel;
	
	private WebDriver driver=null;
	private WebDriverWait wait=null;

	public DetalleHotelPage(WebDriver driver) {
	this.driver=driver;
	this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			

	PageFactory.initElements(driver, this);
	}
	
	public boolean validarTituloHotel() {
		wait.until(ExpectedConditions.visibilityOf(TituloHotel));
		return TituloHotel.isDisplayed();
	}
		
	public String InfoHotel() {
	wait.until(ExpectedConditions.visibilityOf(TituloHotel));
	return TituloHotel.getText();			
	}
	
	
	

}
