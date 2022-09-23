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
	@FindBy(xpath="//div[@class='main-info']//h1[@class='accommodation-name eva-3-h2']")
	private WebElement TituloHotel;
	
	private WebDriver driver=null;
	private WebDriverWait wait=null;

	public DetalleHotelPage(WebDriver driver) {
	this.driver=driver;
	this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			

	PageFactory.initElements(driver, this);
	}
	
	public void InfoHotel() {
		wait.until(ExpectedConditions.visibilityOf(TituloHotel));
		Assert.assertTrue(TituloHotel.isDisplayed(),"No se encuentra el titulo");
		
		
		System.out.println("Hotel Seleccionado "+ TituloHotel.getText());
		/*Assert.assertEquals(TituloHotel.getText(), "Hotel Regente", "No se encontro el Hotel");*/
	}

}
