package com.maysunmedia.flight_nay_autotest.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	protected WebDriver driver;
	protected ChromeDriverService service;
	@BeforeMethod
	public void beforeTest() {
		String driverPath=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", driverPath+"/src/test/resources/driver/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver",driverPath+"/src/test/resources/driver/geckodriver.exe");
		driver=new FirefoxDriver();
//		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverPath+"/src/test/resources/driver/chromedriver.exe")).usingAnyFreePort().build();
//		try {
//			service.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
//		service.stop();
	}
}
