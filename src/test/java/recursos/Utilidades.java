package recursos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Utilidades {
	
	protected WebDriver driver;
 

	public Utilidades(WebDriver driver) {
		this.driver = driver;
	}


	public WebDriver setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		return driver;	
	}

	
	public void tearDown() {
		driver.close();
	}
	
	public void agregarTexto(String imput, By localizador){
		driver.findElement(localizador).sendKeys(imput);
	}
	
	public void clic(By localizador){
		driver.findElement(localizador).click();
	}
	
	public Boolean estaDesplegado(By localizador){
		try {
			return driver.findElement(localizador).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		
	}

	public void visitarSitio(String url){
		driver.get(url);
	}
	
	public String obtenerTexto(By localizador){
		return driver.findElement(localizador).getText();
	}

	public void esperar3segundos() throws InterruptedException{
		Thread.sleep(3000);
	}
}
