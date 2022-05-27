package in.ptmantra.actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	public void implicitWait(WebDriver driver, int timeOut);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	public void click(WebDriver ldriver, WebElement ele);
}
