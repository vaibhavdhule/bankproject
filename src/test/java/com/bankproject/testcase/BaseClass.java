package com.bankproject.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bankproject.utilities.ReadConfig;


public class BaseClass {

	ReadConfig rc = new ReadConfig();
	
	public static Logger logger;
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		
		logger = Logger.getLogger("BankProject");
		
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver", rc.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(rc.getUrl());
	}

	@AfterClass
	public void testDown() {

		driver.quit();
	}

	public void captureScreenShot(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "/ScreenShot" + tname + ".png");

		FileUtils.copyFile(source, dest);

	}

}
