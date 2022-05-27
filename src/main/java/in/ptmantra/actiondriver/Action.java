package in.ptmantra.actiondriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import in.ptmantra.actionInterface.ActionInterface;
import in.ptmantra.base.BaseClass;


public class Action extends BaseClass implements ActionInterface
{   @Override
	public void implicitWait(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
	@Override
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

      
       

       
}
