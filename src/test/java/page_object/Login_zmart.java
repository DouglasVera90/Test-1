package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import recursos.Utilidades;

public class Login_zmart extends Utilidades {

	public Login_zmart(WebDriver driver) {
		super(driver);
	}

	By btnIngresar = By.id("LinkLoginHeader");
	By user = By.xpath("//input[@id='email']");
	By pass = By.xpath("//input[@id='password']");
	By btnLogin = By.xpath(
			"//body/div[@id='fondo']/div[@id='contenedor']/div[@id='cuerpo']/div[@id='registroLogin']/form[1]/div[1]/input[7]");
	By errorLogin = By.xpath("//i[contains(text(),'¿Olvidaste tu Contraseña?')]");

	public void login(String name, String password) throws InterruptedException {
		clic(btnIngresar);
		esperar3segundos();
		agregarTexto(name, user);
		esperar3segundos();
		agregarTexto(password, pass);
		esperar3segundos();
		clic(btnLogin);
		esperar3segundos();
	}
	
	@Test(priority = 4)
	public void test4() throws InterruptedException {
		driver.get("https://www.lider.cl/supermercado/");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/section[2]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/a[1]/div[1]/img[1]"));
		Thread.sleep(3000);
		element.click();
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/section[2]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/p[2]"));
		Assert.assertEquals(element2.getText(), "$5.290");
	}

	public String Obtenermensaje() {
		return obtenerTexto(errorLogin);
	}

}
