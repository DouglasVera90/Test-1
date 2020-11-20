package conexion_chromedriver;

import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ConexionChrome {

	private WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Path path = Paths.get("src\\test\\resources\\chromedriver.exe");
		System.out.println(path);

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.lider.cl/supermercado/");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"productBox[689308]\"]/a/div[1]/img"));
		Thread.sleep(3000);
		element.click();
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath("//div[@id='productBox[689308]"));
		Assert.assertEquals(element2.getText(), "1090");

	}
}


