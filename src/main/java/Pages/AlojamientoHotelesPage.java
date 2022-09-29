package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.DetalleHotelPage;

public class AlojamientoHotelesPage {
	@FindBy(css="div:nth-child(1).results-cluster-container div:nth-child(2).pricebox-action button.eva-3-btn.-md.-primary.-eva-3-fwidth")	
	private WebElement Detalles;
	
	private WebDriver driver=null;
	private WebDriverWait wait=null;
	
	
	public AlojamientoHotelesPage(WebDriver driver) {
		this.driver=driver;		
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
				
		
		PageFactory.initElements(driver, this);
	}
	
	public DetalleHotelPage ClickBotonDetalles() {	
		wait.until(ExpectedConditions.elementToBeClickable(Detalles));
		Detalles.click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
	    return new DetalleHotelPage (this.driver);
	}
}
