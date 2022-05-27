/**
 * 
 */
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
import org.testng.annotations.BeforeClass;

import in.ptmantra.actiondriver.Action;

/**
 * @author RSTPL087
 *
 */
public class BaseClass{

	/**
	 * @param args
	 */
	
	public static Properties pro;
	public static WebDriver driver;
	Action action=new Action();
	@BeforeClass
	public void loadConfig() {
		try {
			pro=new Properties();
			FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\configuration\\config.properties");
			pro.load(fi);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/*public static WebDriver getDriver() {
		return driver.get(); 
	}*/
	
	public void launchApp() {
		String browserName = pro.getProperty("browser");
		if(browserName.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.contains("firefox")){
			driver=new FirefoxDriver();
		}else if(browserName.contains("ie")) {
			driver=new InternetExplorerDriver();
		}else if(browserName.contains("Edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Driver is not found");
		}
		
		action.implicitWait(driver, 20);
		action.pageLoadTimeOut(driver, 30);
		driver.get(pro.getProperty("url"));
		
		
	}

}
