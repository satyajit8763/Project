package com.pacs.automation.tests;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	static WebDriver driver;

	String appUrl = "https://corauiq.azurewebsites.net/login";

	@BeforeTest
	public void beforeTest() {

		File browserDriverServer;
		String baseDir = System.getProperty("user.dir");
		browserDriverServer = new File(baseDir + "\\ExeFiles\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", browserDriverServer.getAbsolutePath());
		String path = System.getProperty("user.dir") + "\\DownloadedFiles";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", path);
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(ChromeOptions.CAPABILITY, opt);
		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appUrl);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public static void pageSync(int num) throws InterruptedException {
		Thread.sleep(num * 1000);
	}

}
