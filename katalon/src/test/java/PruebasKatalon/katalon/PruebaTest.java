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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class PruebaTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		/**
		 * Configuración Chrome
		 */

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

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
		// System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		// driver = new FirefoxDriver();
		
		//this.driver = new HtmlUnitDriver();
		
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testLoginOK() throws Exception {
		
		driver.get("https://www.google.es/");
		//this.takeSnapShot(driver, "evidencias/test1.png");

		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("pc");

		//this.takeSnapShot(driver, "C:\\Users\\rlismanu\\Desktop\\test2.png");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

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

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}

}
