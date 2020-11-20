package conexion_chromedriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test001 {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test(priority = 1)
	public void test1() throws InterruptedException {
		driver.get("https://www.zmart.cl/");
		WebElement btnIngresar;
		String urlEsperada = "https://www.zmart.cl/Scripts/10_Logon.asp?action=logon&idOrder=&idproduct=&randomKey=&urlkey=";

		try {
			Thread.sleep(5000);
			btnIngresar = driver.findElement(By.id("LinkLoginHeader"));
			Thread.sleep(3000);
			btnIngresar.click();
		} catch (NoSuchElementException e) {

		}

		Thread.sleep(10000);
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), urlEsperada);

	}

	@Test(priority = 2)
	public void test2() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/register.php");

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");
		Thread.sleep(3000);
		assertNotNull(drpCountry.getOptions());
		

	}

	@Test(priority = 3)
	public void test3() throws InterruptedException {
		driver.get("https://www.lider.cl/supermercado/");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//a[@class='item']//span[contains(text(),'Departamentos')]"));
		Thread.sleep(3000);
		Assert.assertNotNull(element);
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

	@Test(priority = 5)
	public void test5() throws InterruptedException {
	       driver.get("https://www.zmart.cl/");
	       WebElement linkPs4 = driver.findElement(By.id("menu11"));
	       Actions action = new Actions(driver);
	       action.moveToElement(linkPs4).build().perform();
	       Thread.sleep(1000);
		   WebElement btnConsola = driver.findElement(By.xpath("//a[@id='menu81']"));
		   btnConsola.click();
		   WebElement consola = driver.findElement(By.xpath("//div[@id='BoxProdDisplay73323']"));
		   Assert.assertTrue(consola.isDisplayed());
	}

}
