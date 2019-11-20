package PruebasKatalon.katalon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventListener extends AbstractWebDriverEventListener {
	
	private static int numeroEvidencia = 0;
	
	@Override
	public void beforeClickOn(WebElement webElement, WebDriver driver) {
		this.numeroEvidencia++;
		try {
			/* Take screenshot when exception happened. */
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			/* save screenshot to file. */
			FileUtils.copyFile(scrFile, new File("evidencias/EV_0" + this.numeroEvidencia + ".png"));
		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}

}
