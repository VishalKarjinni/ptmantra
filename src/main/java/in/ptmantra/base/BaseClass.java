package in.ptmantra.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class
 * 
 */
public class BaseClass {
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	// loadConfig method is to load the configuration

	@BeforeSuite
	public void loadConfig() {
		/* ExtentManager.setExtent(); */
		try {
			prop = new Properties();
			FileInputStream pro = new FileInputStream(
					System.getProperty("user.dir") + "\\configuration\\config.properties");
			prop.load(pro);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getbaseUrl() {
		String baseurl = prop.getProperty("url");
		return baseurl;
	}

	public static String getusername() {
		String username = prop.getProperty("username");
		return username;
	}

	public static String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	@Parameters("browser")
	public void launchApp(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		/*
		 * getDriver().manage().timeouts().implicitlyWait
		 * (Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		 */
		// PageLoad TimeOuts
		/*
		 * getDriver().manage().timeouts().pageLoadTimeout
		 * (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		 */
		// Launching the URL
		getDriver().get("https://qa.ptmantra.com/");
	}
	/*
	 * @AfterSuite public void afterSuite() { ExtentManager.endReport(); }
	 */

}
