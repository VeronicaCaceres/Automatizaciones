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
	@FindBy(xpath="//div[1][@class='results-cluster-container']//div[@class='pricebox-action']//button[@class='eva-3-btn -md -primary -eva-3-fwidth']")
	private WebElement Detalles;
	
	private WebDriver driver=null;
	private WebDriverWait wait=null;
	
	
	public AlojamientoHotelesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;		
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
				
		
		PageFactory.initElements(driver, this);
	}
	
	public DetalleHotelPage ClickBotonDetalles()throws Exception {	
		wait.until(ExpectedConditions.elementToBeClickable(Detalles));
		Thread.sleep(3000);
		Detalles.click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
	    return new DetalleHotelPage (this.driver);
	}
}
