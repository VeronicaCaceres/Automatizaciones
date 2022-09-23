package com.files.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	private enum browsers{
	      CHROME, FIREFOX, EDGE
	 }
	public static WebDriver AbrirBrowser(String browserName, String url) {
		WebDriver driver = null;
		switch(browsers.valueOf(browserName))  {
			case CHROME:{
				System.setProperty("webdriver.chrome.driver", "E:\\Descargas\\zip maven-chromedrive-seleniun\\chromedriver_win32\\chromedriver.exe"); 
				System.out.print("Iniciando Chrome");
				ChromeOptions option = new ChromeOptions();		
				option.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(option);
				break;
			}	
			case FIREFOX:{
				System.setProperty("webdriver.gecko.driver", "E:\\Descargas\\zip maven-chromedrive-seleniun\\geckodriver.exe"); 
				System.out.print("Iniciando Chrome");
				driver = new FirefoxDriver();
				break;	
			}			    
			case EDGE:{
				System.setProperty("webdriver.edge.driver", "E:\\Descargas\\zip maven-chromedrive-seleniun\\edgedriver_win64\\edgedriver.exe"); 
				System.out.print("Iniciando Edge");
				driver = new EdgeDriver();
				break;
			}	
			default:{
				System.out.print("No se eligio ningun navegador");
				System.setProperty("webdriver.chrome.driver", "E:\\Descargas\\zip maven-chromedrive-seleniun\\chromedriver_win32\\chromedriver.exe");
				System.out.print("Iniciando Chrome");
				driver = new ChromeDriver();
				break;
	
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
}
	
       public static void CerrarBrowser(WebDriver driver) {
    	   driver.quit();
       }
}

