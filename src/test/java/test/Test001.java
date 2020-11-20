package test;

import org.testng.annotations.Test;
import page_object.Login_zmart;
import recursos.DataDriven;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Test001 {
	Login_zmart login;
	private WebDriver driver;
	private DataDriven datadriven;
	private ArrayList<String> data;

	@Test
	public void login() throws IOException, InterruptedException {
		data = datadriven.getData("Login_zmart");
		login.login((String)data.get(1),(String)data.get(2));
		System.out.println(login.Obtenermensaje());
		assertTrue(login.Obtenermensaje().contains((String)data.get(3)));
		
	}

	@BeforeMethod
	public void before() {
		login = new Login_zmart(driver);
		driver = login.setUp();
		login.visitarSitio("https://www.zmart.cl/Scripts/default.asp");
	}

	@AfterMethod
	public void after() {

		login.tearDown();
	}

	@BeforeClass
	public void beforeClass() {
		datadriven = new DataDriven();
		data = new ArrayList<String>();		
	}

}
