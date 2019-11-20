package PruebasKatalon.katalon;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class PruebaTest {
	private WebDriver eventFiring;
	private String baseUrl;
	private EventListener event;
	private EventFiringWebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	private static String resurso = "";

	@Before
	public void setUp() throws Exception {
		/**
		 * Configuración Chrome
		 */

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		eventFiring = new ChromeDriver();

		/**
		 * Cofiguración Internet Explorer
		 */

		/*
		 * System.setProperty("webdriver.ie.driver", "IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver();
		 */

		/**
		 * Configuración Firefox
		 */
		//System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		//driver = new FirefoxDriver();

		
		this.driver = new EventFiringWebDriver(this.eventFiring);
		this.event = new EventListener();
		
		this.driver.register(event);

		baseUrl = "https://www.katalon.com/";
		this.driver.manage().window().maximize();
	}

	@Test
	public void testgitHubOK() throws Exception {
		driver.get("https://www.google.es/");
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("github");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Resultado web con enlaces al sitio web'])[1]/following::span[1]")).click();
	}
	
	@Test
	public void testfacebookOK() throws Exception {
		driver.get("https://www.google.es/");
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("facebook");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anuncio'])[1]/following::span[1]")).click();
	  
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	private static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {		

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	
		File DestFile = new File(fileWithPath); 
		
		FileUtils.copyFile(SrcFile, DestFile);

	}
}
