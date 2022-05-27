/**
 * 
 */
package in.ptmantra.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;

/**
 * @author RSTPL087
 *
 */
public class LoginPage extends BaseClass {
    Action action=new Action();
	@FindBy(name="username")
	WebElement usernametext;
	
	@FindBy(name="password")
	WebElement passwordtext;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id='showhide']")
	WebElement showhide;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Dashboard clickLogin() {
	    action.click(driver, loginbtn);
		return new Dashboard();
	}
	
 
}
